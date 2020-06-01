package com.psawesome.testcodeproject.baekjoon;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

  private static int answer = Integer.MAX_VALUE;

  private static Queue<String> q;

  public int solution(String s) {

    String[] str = s.split("");

    q = new LinkedList<>();

    Collections.addAll(q, str);

    calculation(1);

    return answer;
  }

  private static void calculation(int div) {

    StringBuilder sb = new StringBuilder();

    int cnt = 1;

    Queue<String> q2 = new LinkedList<>(q);

    String pre = "";
    boolean check = false;

    while (q2.peek() != null) {

      StringBuilder cur = new StringBuilder();

      for (int i = 0; i < div; i++) {
        if (q2.peek() != null) {
          cur.append(q2.poll());
        }
      }

      if (pre.equals(cur.toString())) {
        check = true;
        cnt++;
      } else {
        if (cnt != 1) {
          sb.append(cnt);
          cnt = 1;
        }
        sb.append(cur);
        check = false;
      }
      pre = cur.toString();

      if (q2.peek() == null && cnt != 1) {
        sb.append(cnt);
      }
    }

    if (answer >= sb.length()) {
      answer = sb.length();
    }


    if (q.size() / 2 == div) {
      return;
    } else {
      calculation(div + 1);
    }
  }
}