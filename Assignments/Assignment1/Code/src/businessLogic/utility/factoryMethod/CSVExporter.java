package businessLogic.utility.factoryMethod;

public class CSVExporter extends  Exporter {
    @Override
    public ExportAlgorithm getExportAlgorithm() {
        return new CSVExportAlgorithm();
    }
}
