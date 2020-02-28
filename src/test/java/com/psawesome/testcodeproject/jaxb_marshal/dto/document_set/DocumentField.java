package com.psawesome.testcodeproject.jaxb_marshal.dto.document_set;

import com.psawesome.testcodeproject.jaxb_marshal.dto.MarshallAdapter;
import org.springframework.data.annotation.AccessType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author pilseong
 * @version 1.0
 * @description
 * @see == 개정이력(Modification Information) ==
 * <p>
 * 수정일             수정자            수정내용
 * ------          --------      --------------------------
 * @since 2020-02-27
 */

public class DocumentField {
    private String docid;
    private String total_id;
    private String article_id;
    private String source_code;
    private String view_flag;
    private String art_type;
    private String service_day;
    private String service_time;
    private String content_type;
    private String pressdate;
    private String presscategory;
    private String pressmyun;
    private String art_cre_time;
    private String art_upd_time;
    private String source_name;
    private String search_code;
    private String portal_code;
    private String media_code;
    private String master_code_list;
    private String service_code;
    private String section_name;
    private String service_code_list;
    private String section_name_list;
    private String art_thumb;
    private String art_title;
    private String mob_title;
    private String art_reporter;
    private String art_subtitle;
    private String art_kwd;
    private String service_fullcode;
    private String art_content;
    private String reporter_group;
    private String src_grp_cd;
    private String art_rep_no;
    private String date;
    private String joongang_use;
    private String ilgan_use;
    private String newsalias;
    private String dup_title;

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setDocid(String docid) {
        this.docid = docid;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setTotal_id(String total_id) {
        this.total_id = total_id;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setArticle_id(String article_id) {
        this.article_id = article_id;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setSource_code(String source_code) {
        this.source_code = source_code;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setView_flag(String view_flag) {
        this.view_flag = view_flag;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setArt_type(String art_type) {
        this.art_type = art_type;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setService_day(String service_day) {
        this.service_day = service_day;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setService_time(String service_time) {
        this.service_time = service_time;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setContent_type(String content_type) {
        this.content_type = content_type;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setPressdate(String pressdate) {
        this.pressdate = pressdate;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setPresscategory(String presscategory) {
        this.presscategory = presscategory;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setPressmyun(String pressmyun) {
        this.pressmyun = pressmyun;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setArt_cre_time(String art_cre_time) {
        this.art_cre_time = art_cre_time;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setArt_upd_time(String art_upd_time) {
        this.art_upd_time = art_upd_time;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setSource_name(String source_name) {
        this.source_name = source_name;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setSearch_code(String search_code) {
        this.search_code = search_code;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setPortal_code(String portal_code) {
        this.portal_code = portal_code;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setMedia_code(String media_code) {
        this.media_code = media_code;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setMaster_code_list(String master_code_list) {
        this.master_code_list = master_code_list;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setService_code(String service_code) {
        this.service_code = service_code;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setSection_name(String section_name) {
        this.section_name = section_name;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setService_code_list(String service_code_list) {
        this.service_code_list = service_code_list;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setSection_name_list(String section_name_list) {
        this.section_name_list = section_name_list;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setArt_thumb(String art_thumb) {
        this.art_thumb = art_thumb;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setArt_title(String art_title) {
        this.art_title = art_title;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setMob_title(String mob_title) {
        this.mob_title = mob_title;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setArt_reporter(String art_reporter) {
        this.art_reporter = art_reporter;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setArt_subtitle(String art_subtitle) {
        this.art_subtitle = art_subtitle;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setArt_kwd(String art_kwd) {
        this.art_kwd = art_kwd;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setService_fullcode(String service_fullcode) {
        this.service_fullcode = service_fullcode;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setArt_content(String art_content) {
        this.art_content = art_content;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setReporter_group(String reporter_group) {
        this.reporter_group = reporter_group;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setSrc_grp_cd(String src_grp_cd) {
        this.src_grp_cd = src_grp_cd;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setArt_rep_no(String art_rep_no) {
        this.art_rep_no = art_rep_no;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setDate(String date) {
        this.date = date;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setJoongang_use(String joongang_use) {
        this.joongang_use = joongang_use;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setIlgan_use(String ilgan_use) {
        this.ilgan_use = ilgan_use;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setNewsalias(String newsalias) {
        this.newsalias = newsalias;
        return this;
    }

    @XmlJavaTypeAdapter(value = MarshallAdapter.class)
    public DocumentField setDup_title(String dup_title) {
        this.dup_title = dup_title;
        return this;
    }

    public String getDocid() {
        return docid;
    }

    public String getTotal_id() {
        return total_id;
    }

    public String getArticle_id() {
        return article_id;
    }

    public String getSource_code() {
        return source_code;
    }

    public String getView_flag() {
        return view_flag;
    }

    public String getArt_type() {
        return art_type;
    }

    public String getService_day() {
        return service_day;
    }

    public String getService_time() {
        return service_time;
    }

    public String getContent_type() {
        return content_type;
    }

    public String getPressdate() {
        return pressdate;
    }

    public String getPresscategory() {
        return presscategory;
    }

    public String getPressmyun() {
        return pressmyun;
    }

    public String getArt_cre_time() {
        return art_cre_time;
    }

    public String getArt_upd_time() {
        return art_upd_time;
    }

    public String getSource_name() {
        return source_name;
    }

    public String getSearch_code() {
        return search_code;
    }

    public String getPortal_code() {
        return portal_code;
    }

    public String getMedia_code() {
        return media_code;
    }

    public String getMaster_code_list() {
        return master_code_list;
    }

    public String getService_code() {
        return service_code;
    }

    public String getSection_name() {
        return section_name;
    }

    public String getService_code_list() {
        return service_code_list;
    }

    public String getSection_name_list() {
        return section_name_list;
    }

    public String getArt_thumb() {
        return art_thumb;
    }

    public String getArt_title() {
        return art_title;
    }

    public String getMob_title() {
        return mob_title;
    }

    public String getArt_reporter() {
        return art_reporter;
    }

    public String getArt_subtitle() {
        return art_subtitle;
    }

    public String getArt_kwd() {
        return art_kwd;
    }

    public String getService_fullcode() {
        return service_fullcode;
    }

    public String getArt_content() {
        return art_content;
    }

    public String getReporter_group() {
        return reporter_group;
    }

    public String getSrc_grp_cd() {
        return src_grp_cd;
    }

    public String getArt_rep_no() {
        return art_rep_no;
    }

    public String getDate() {
        return date;
    }

    public String getJoongang_use() {
        return joongang_use;
    }

    public String getIlgan_use() {
        return ilgan_use;
    }

    public String getNewsalias() {
        return newsalias;
    }

    public String getDup_title() {
        return dup_title;
    }
}
