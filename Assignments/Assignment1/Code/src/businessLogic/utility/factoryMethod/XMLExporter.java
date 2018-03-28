package businessLogic.utility.factoryMethod;

public class XMLExporter extends Exporter {
    @Override
    public ExportAlgorithm getExportAlgorithm() {
        return new XMLExportAlgorithm();
    }
}
