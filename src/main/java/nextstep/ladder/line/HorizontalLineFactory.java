package nextstep.ladder.line;

import nextstep.ladder.point.Point;
import nextstep.ladder.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class HorizontalLineFactory {

    public static HorizontalLine generate(int numberOfParticipants) {
        List<Point> points = new ArrayList<>();

        Point first = getFirstPoint();
        points.add(first);

        List<Point> body = getBody(first, numberOfParticipants);
        points.addAll(body);

        Point last = getLastPoint(points);
        points.add(last);

        return new HorizontalLine(points);
    }

    private static Point getLastPoint(List<Point> points) {
        int lastIndex = points.size() - 1;
        Point point = points.get(lastIndex);
        return point.last();
    }

    private static Point getFirstPoint() {
        boolean movableRight = RandomBooleanGenerator.generate();
        Point first = Point.first(movableRight);
        return first;
    }

    private static List<Point> getBody(Point first, int numberOfParticipants) {
        List<Point> points = new ArrayList<>();
        int bodySize = numberOfParticipants - 2; // first, last 제외한 갯수

        Point point = first;
        for (int i = 0; i < bodySize; i++) {
            point = point.next();
            points.add(point);
        }

        return points;
    }
}
