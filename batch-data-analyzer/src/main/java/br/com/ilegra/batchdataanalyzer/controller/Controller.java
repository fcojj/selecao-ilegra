package br.com.ilegra.batchdataanalyzer.controller;

import br.com.ilegra.batchdataanalyzer.model.BatchProcessor;
import br.com.ilegra.batchdataanalyzer.model.ModelFactory;
import br.com.ilegra.batchdataanalyzer.model.ReportDate;

/**
 * Controller incializa the process of analysis and reporting.
 * Created by Fco Jonas Rodrigues on 09/08/2016.
 */
public class Controller {

    private BatchProcessor batchProcessor;
    private ModelFactory modelFactory;
    private ReportDate reportDate;

    public Controller() {
        this.batchProcessor = new BatchProcessor();
        this.modelFactory = new ModelFactory();
        this.reportDate = new ReportDate();
    }

    public void lotsProcess(){
        batchProcessor.process(modelFactory, reportDate);
    }
}
