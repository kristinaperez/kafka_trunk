package org.example.etldatahandler.dto.messageformat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.lang.reflect.Field;

@ToString
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KafkaRawHoData extends KafkaData{
    String company_type;
    String bs_emp_id2;
    String assigned_mir_sp;
    String ra_region;
    String okato;
    String ra_city;
    String dir_email;
    String agr_ccy;
    String la_region;
    String user_lk_phone;
    String latname;
    String id;
    String pmf_business_gid;
    String rec_created;
    String open_date;
    String ra_postal_code;
    String natname;
    String dir_name;
    String dir_phone;
    String sa_email;
    String kpp;
    String assigned_visa_sp;
    String ra_address;
    String def_frame_h;
    String activeflag;
    String min_threshold;
    String acc_name;
    String agt19;
    String acc_phone;
    String sa_phone_number;
    String acc_email;
    String ra_region_code;
    String agt15;
    String lastModified;
    String la_address;
    String ra_city_code;
    String allow_pmnt;
    String sa_name;
    String note;
    String user_lk_name;
    String role;
    String la_region_code;
    String user_lk_email;
    String party_client_id;
    String ra_country;
    String bs_email;
    String hoid;
    String la_postal_code;
    String bs_phone_number;
    String pmf_bank_id;
    String la_country;
    String pay_priority;
    String taxpayer_type;
    String allow_join;
    String la_city;
    String inn;
    String okpo;
    String product_schema;
    String assigned_mc_sp;
    String kbk;
    String okved;
    String party_id;
    String bs_name;
    String source_code;
}
