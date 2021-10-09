package bridge;

interface Renderer{
    public String whatToRenderAs();
}
abstract class Shape
{
    Renderer renderer;
    public abstract String getName();
    Shape(Renderer renderer){
        this.renderer = renderer;
    }
}

class Triangle extends Shape
{
    @Override
    public String getName()
    {
        return "Triangle";
    }

    Triangle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(),renderer.whatToRenderAs());
    }
}

class Square extends Shape
{
    @Override
    public String getName()
    {
        return "Square";
    }

    Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(),renderer.whatToRenderAs());
    }
}

class VectorRenderer implements Renderer
{

    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}

class RasterRenderer implements Renderer
{
    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}

// imagine VectorTriangle and RasterTriangle are here too
