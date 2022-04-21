package framework.framework.model;

public class Redirect {

    private String extension;

    private String destinationName;

    private String destinationType;

    public Redirect(String extension, String destinationName, String destinationType) {
        this.extension = extension;
        this.destinationName = destinationName;
        this.destinationType = destinationType;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(String destinationType) {
        this.destinationType = destinationType;
    }
}
