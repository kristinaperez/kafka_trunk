package org.example.etldatahandler.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.etldatahandler.dto.KafkaRecordDto;
import org.example.etldatahandler.model.KafkaRecord;
import org.example.etldatahandler.repository.KafkaRecordRepository;
import org.example.etldatahandler.service.KafkaRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KafkaRecordServiceImpl implements KafkaRecordService {

    @Autowired
    private final KafkaRecordRepository kafkaRecordRepository;

    @Override
    public List<KafkaRecordDto> findAll() {

        List<KafkaRecord> kafkaRecords = kafkaRecordRepository.findAll();
        return kafkaRecords.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private KafkaRecordDto convertEntityToDto(KafkaRecord kafkaRecord) {

        KafkaRecordDto kafkaRecordDto = KafkaRecordDto.builder()
                .id(kafkaRecord.getId())
                .hoid(kafkaRecord.getHoid())
                .role(kafkaRecord.getRole())
                .asam_profile(kafkaRecord.getAsam_profile())
                .mid(kafkaRecord.getMid())
                .model(kafkaRecord.getModel())
                .lastModified(kafkaRecord.getLastModified())
                .activeflag(kafkaRecord.getActiveflag())
                .tid(kafkaRecord.getTid())
                .build();

        return kafkaRecordDto;
    }

    private KafkaRecord convertDtoToEntity(KafkaRecordDto kafkaRecordDto) {
        return KafkaRecord.builder()
                .id(kafkaRecordDto.getId())
                .hoid(kafkaRecordDto.getHoid())
                .role(kafkaRecordDto.getRole())
                .asam_profile(kafkaRecordDto.getAsam_profile())
                .mid(kafkaRecordDto.getMid())
                .model(kafkaRecordDto.getModel())
                .lastModified(kafkaRecordDto.getLastModified())
                .activeflag(kafkaRecordDto.getActiveflag())
                .tid(kafkaRecordDto.getTid())
                .build();
    }

    public Optional<KafkaRecordDto> findKafkaRecordByName(String name) {
        return kafkaRecordRepository.findKafkaRecordByName(name);
    }

    @Override
    public Optional<KafkaRecordDto> findById(Integer integer) {
        return Optional.empty();
    }

    public KafkaRecordDto addKafkaRecordDto(KafkaRecordDto kafkaRecordCreateDto) {

        KafkaRecord kafkaRecord = kafkaRecordRepository.save(convertDtoToEntity(kafkaRecordCreateDto));
        KafkaRecordDto  kafkaRecordDto = convertEntityToDto(kafkaRecord);
        return kafkaRecordDto;
    }

    public KafkaRecordDto updateKafkaRecordDto(KafkaRecordDto kafkaRecordDto) {

        KafkaRecord kafkaRecord = kafkaRecordRepository.findById(Long.valueOf(kafkaRecordDto.getId())).orElseThrow();
        return kafkaRecordDto;
    }

    public void removeKafkaRecordDto(Long kafkaRecordId) {
        kafkaRecordRepository.deleteById(kafkaRecordId);
    }

}
