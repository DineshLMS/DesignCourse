class Point
{
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Point(x,y);
    }
}

class Line
{
    public Point start, end;

    public Line(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy()
    {
        Line line=null;
        try {
            line = new Line((Point) start.clone(), (Point) end.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return line;
        // todo
    }
}
