package org.example.etldatahandler.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum PipelineCodeEnum {
    MERCHANTS_EXPORT_INCREMENTAL(
            "MERCHANTS-EXPORT-INCREMENTAL",
            null,
            UnloadType.INCREMENT,
            "kafka",
            "ucs-static-incr",
            "SPC-RUSUCSACQ-DATAFROM-STH",
            "Выгрузка данных по MID"),

    MERCHANTS_EXPORT_FULL(
            "MERCHANTS-EXPORT-FULL",
            null,
            UnloadType.FULL,
            "kafka",
            "ucs-static-full",
            "SPC-RUSUCSACQ-DATAFROM-STH",
            "Выгрузка данных по MID"),

    TERMINALS_EXPORT_INCREMENTAL(
            "TERMINALS-EXPORT-INCREMENTAL",
            null,
            UnloadType.INCREMENT,
            "kafka",
            "ucs-static-incr",
            "SPC-RUSUCSACQ-DATAFROM-STH",
            "Выгрузка данных по TID"),

    TERMINALS_EXPORT_FULL(
            "TERMINALS-EXPORT-FULL",
            null,
            UnloadType.FULL,
            "kafka",
            "ucs-static-full",
            "SPC-RUSUCSACQ-DATAFROM-STH",
            "Выгрузка данных по TID"),

    RETAIL_CHAINS_EXPORT_INCREMENTAL(
            "RETAIL-CHAINS-EXPORT-INCREMENTAL",
            null,
            UnloadType.INCREMENT,
            "kafka",
            "ucs-static-incr",
            "SPC-RUSUCSACQ-DATAFROM-STH",
            "Выгрузка данных по ТСП"),

    RETAIL_CHAINS_EXPORT_FULL(
            "RETAIL-CHAINS-EXPORT-FULL",
            null,
            UnloadType.INCREMENT,
            "kafka",
            "ucs-static-full",
            "SPC-RUSUCSACQ-DATAFROM-STH",
            "Выгрузка данных по ТСП"),

    OPERATIONS_EXPORT_INCREMENTAL(
            "OPERATIONS-EXPORT-INCREMENTAL",
            null,
            UnloadType.INCREMENT,
            "kafka",
            "ucs-operations",
            "SPC-RUSUCSACQ-DATAFROM-STH",
            "Выгрузка данных по транзакциям");

    String code;
    List<String> params;
    UnloadType unloadType;
    String consumer;
    String topic;
    String mapper;
    String name;
}
