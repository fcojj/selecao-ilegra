package br.com.ilegra.batchdataanalyzer.extractor;

import br.com.ilegra.batchdataanalyzer.bean.Bean;

import java.util.List;

/**
 * Created by Jonas Rodrigues on 09/08/2016.
 */
public interface Extractor {
    Bean extract(List<String> data);
}
