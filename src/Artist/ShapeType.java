package Artist;

public enum ShapeType {
    CIRCLE("circle"),
    RECTANGLE("rectangle");
    private String shapeName;
    ShapeType(String shapeName) {
        this.shapeName = shapeName;
    }

    public String getShapeName() {
        return shapeName;
    }
}
