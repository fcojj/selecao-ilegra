package br.com.ilegra.batchdataanalyzer.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 *
 * Created by Jonas Rodrigues on 07/08/2016.
 */
public class BatchProcessor {

    private static String DIR_LOTS_RELATIVE_URL = "{0}/data/in" ;
    private static String DIR_REPORT_RELATIVE_URL = "{0}/data/out" ;
    private static final Logger LOGGER = Logger.getLogger(BatchProcessor.class.getName());


    public BatchProcessor(){
    }

    private String getUrl(String relativeUrl){
        String urlAbsolute = System.getProperty("user.home");

        return MessageFormat.format(relativeUrl, urlAbsolute);
    }

    public void process(ModelFactory modelFactory, ReportDate reportDate) {
        try {
            List<File> filesInFolder = getDatFiles();

            for(File file : filesInFolder){
                fileDatProcess(modelFactory, file);
                generateReport(modelFactory, file.getName(), reportDate);
            }

        } catch (IOException e1){
            LOGGER.log(Level.INFO, "Directory in of lots not found, change the constant DIR_LOTS_RELATIVE_URL or create directory.", e1);
        }
    }

    private void fileDatProcess(ModelFactory modelFactory, File file) {
        try {

            Files.readAllLines(file.toPath()).forEach(line->{
                modelFactory.manufactureModel(Arrays.asList(line.split("ç")));
            });
           file.renameTo(new File(file.getAbsoluteFile().toString()+"[PROCCESSED]"));
        } catch (IOException e2) {
            LOGGER.log(Level.INFO, "File lot not available", e2);
        }
    }

    private List<File> getDatFiles() throws IOException {
        File dir = new File(getUrl(DIR_LOTS_RELATIVE_URL));
        if (!dir.exists()) {
            dir.createNewFile();
        }
        return Files.walk(Paths.get(getUrl(DIR_LOTS_RELATIVE_URL)))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().toLowerCase().endsWith(".dat"))
                .filter(path -> !path.toString().toLowerCase().endsWith("[PROCCESSED]"))
                .map(Path::toFile)
                .collect(Collectors.toList());
    }

    public void generateReport(ModelFactory modelFactory, String nameFile, ReportDate reportDate){

        try {
            BufferedWriter writer = null;
            File file = new File(getUrl(DIR_REPORT_RELATIVE_URL)+"/"+nameFile+".done.dat");
            FileWriter fw = new FileWriter(file);
            writer = new BufferedWriter(fw);

            writer.write("Amount of clients in the input file: "+String.valueOf(reportDate.getAmountCustomerCurrentFileDat(modelFactory)));
            writer.newLine();
            writer.write("Amount of salesman in the input file : "+String.valueOf(reportDate.getAmountSalesmanCurrentFileDat(modelFactory)));
            writer.newLine();
            writer.write("ID of the most expensive sale(for all the lots already processed): "+reportDate.getBestSaleId(modelFactory));
            writer.newLine();
            writer.write("Worst salesman ever(for all the lots already processed): "+reportDate.getWorstSalesman(modelFactory));
            writer.newLine();
            writer.flush();
            writer.close();

        }catch(IOException e){
           LOGGER.log(Level.INFO, "Directory for out report not available, please create.", e);
        }
    }
}
