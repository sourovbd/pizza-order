package com.ehrlich.codechallenge.validation.strategy;

import com.ehrlich.codechallenge.Entity.Pizza;
import com.ehrlich.codechallenge.model.CsvPizzaData;
import com.ehrlich.codechallenge.repository.PizzaCsvImportRepository;
import com.ehrlich.codechallenge.service.GenericResponseService;
import com.opencsv.CSVReader;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvBeanIntrospectionException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.apache.commons.lang3.StringUtils.isNumeric;

@Slf4j
public class ManualImportedCsvDeviceMappingStrategy<T extends CsvPizzaData> implements MappingStrategy<T> {

    public static List<GenericResponseService.FieldValidationErrorsResponse> csvDataFormatViolations = new CopyOnWriteArrayList<>();
    public static Map<String, Set<Integer>> imeiFreqMap = new HashMap<>();
    public static List<GenericResponseService.FieldValidationErrorsResponse> csvDataViolations = new CopyOnWriteArrayList<>();

    private final PizzaCsvImportRepository pizzaCsvImportRepository;

    public ManualImportedCsvDeviceMappingStrategy(PizzaCsvImportRepository pizzaCsvImportRepository) {
        csvDataFormatViolations = new CopyOnWriteArrayList<>();
        csvDataViolations = new CopyOnWriteArrayList<>();
        imeiFreqMap = new HashMap<>();
        this.pizzaCsvImportRepository = pizzaCsvImportRepository;
    }

    @Override
    public void captureHeader(CSVReader csvReader) {}

    @Override
    public String[] generateHeader(T t) {return null;}

    @Override
    public void setType(Class<? extends T> aClass) throws CsvBadConverterException {}

    @Override
    public String[] transmuteBean(T t) {return null;}

    @Override
    public T populateNewBean(String[] line) throws CsvBeanIntrospectionException {
        CsvPizzaData CsvPizzaData = new CsvPizzaData();


        return (T) CsvPizzaData;
    }
}
