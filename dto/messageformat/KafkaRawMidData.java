package org.example.etldatahandler.dto.messageformat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KafkaRawMidData extends KafkaData{
    String mirid;
    String country;
    String mcid;
    String qcash;
    String role;
    String visaid;
    String city;
    String bonus;
    String city_nat;
    String mid;
    String grp_name;
    String mcc;
    String ecomm;
    String sales;
    String amexid;
    String hoid;
    String latname;
    String id;
    String credit;
    String email;
    String rec_created;
    String grpid;
    String jcbid;
    String allow_join;
    String address;
    String natname;
    String ho_entity;
    String recurring;
    String postcode;
    String asam_profile;
    String inn_ho_ba;
    String date_to;
    String activeflag;
    String moto;
    String cupid;
    String web_url;
    String fias_code;
    String region_nat;
    String mm_programm;
    String party_id;
    String mir_loyaltyid;
    String address_lat;
    String lastModified;
    String pmf_ecomm_service_provider;
    String region;
    String refund;
    String region_code;
    String date_from;
}
