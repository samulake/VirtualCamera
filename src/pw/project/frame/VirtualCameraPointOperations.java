package pw.project.frame;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VirtualCameraPointOperations {
	
	public static Map<String, Function<Point3D, Point3D>> operationsMap;
	private static int step = 20;
	private static double rotateStep = 5;
	private static double zoomStep = 5;
	
	public final static BiFunction<Function<Point3D, Point3D>, Cube, Cube> moveCube = (movePoint, cube) -> {
		cube.points = cube.points.stream().map(movePoint).collect(Collectors.toList());
		return cube;
	};
	
	static {
		operationsMap = new HashMap<>();
		
		operationsMap.put("Basic RIGHT", point -> {
			point.x -= step;
			return point;
		});
		operationsMap.put("Basic LEWO", point -> {
			point.x += step;
			return point;
		});
		operationsMap.put("Basic DÓŁ", point -> {
			point.y -= step;
			return point;
		});
		operationsMap.put("Basic GÓRA", point -> {
			point.y += step;
			return point;
		});
		operationsMap.put("Basic W TYŁ", point -> {
			point.z += step;
			return point;
		});
		operationsMap.put("Basic W PRZÓD", point -> {
			point.z -= step;
			return point;
		});
		operationsMap.put("Obrót LEWO", point -> {
			point.x = (point.x * Math.cos((-1) * rotateStep * Math.PI/180)) - (point.z*Math.sin((-1)*rotateStep* (Math.PI/180)));
			point.z = (point.x * Math.sin((-1) * rotateStep * Math.PI/180)) + (point.z*Math.cos((-1)*rotateStep* Math.PI/180));
			//cubes[k][o][0] = (cubes[k][o][0] * Math.cos((-1) * rotateStep * Math.PI/180)) - (cubes[k][o][2] * Math.sin((-1) * rotateStep * Math.PI/180));
			//cubes[k][o][2] = (cubes[k][o][0] * Math.sin((-1) * rotateStep * Math.PI/180)) + (cubes[k][o][2] * Math.cos((-1) * rotateStep * Math.PI/180));
			return point;
		});
		operationsMap.put("Obrót PRAWO", point -> {
			point.x = (point.x * Math.cos(rotateStep * Math.PI/180)) - (point.z*Math.sin(rotateStep* (Math.PI/180)));
			point.z = (point.x * Math.sin(rotateStep * Math.PI/180)) + (point.z*Math.cos(rotateStep* Math.PI/180));
			//cubes[k][o][0] = (cubes[k][o][0] * Math.cos((-1) * rotateStep * Math.PI/180)) - (cubes[k][o][2] * Math.sin((-1) * rotateStep * Math.PI/180));
			//cubes[k][o][2] = (cubes[k][o][0] * Math.sin((-1) * rotateStep * Math.PI/180)) + (cubes[k][o][2] * Math.cos((-1) * rotateStep * Math.PI/180));
			return point;
		});
		operationsMap.put("Obrót GÓRA", point -> {
			point.y = (point.y * Math.cos((-1) * rotateStep * Math.PI/180)) - (point.z*Math.sin((-1)*rotateStep* (Math.PI/180)));
			point.z = (point.y * Math.sin((-1) * rotateStep * Math.PI/180)) + (point.z*Math.cos((-1)*rotateStep* Math.PI/180));
			//cubes[k][o][0] = (cubes[k][o][0] * Math.cos((-1) * rotateStep * Math.PI/180)) - (cubes[k][o][2] * Math.sin((-1) * rotateStep * Math.PI/180));
			//cubes[k][o][2] = (cubes[k][o][0] * Math.sin((-1) * rotateStep * Math.PI/180)) + (cubes[k][o][2] * Math.cos((-1) * rotateStep * Math.PI/180));
			return point;
		});
		operationsMap.put("Obrót DÓŁ", point -> {
			point.y = (point.y * Math.cos(rotateStep * Math.PI/180)) - (point.z*Math.sin(rotateStep* (Math.PI/180)));
			point.z = (point.y * Math.sin(rotateStep * Math.PI/180)) + (point.z*Math.cos(rotateStep* Math.PI/180));
			//cubes[k][o][0] = (cubes[k][o][0] * Math.cos((-1) * rotateStep * Math.PI/180)) - (cubes[k][o][2] * Math.sin((-1) * rotateStep * Math.PI/180));
			//cubes[k][o][2] = (cubes[k][o][0] * Math.sin((-1) * rotateStep * Math.PI/180)) + (cubes[k][o][2] * Math.cos((-1) * rotateStep * Math.PI/180));
			return point;
		});
		
		operationsMap.put("Przekrzywienie PRAWO", point -> {
			point.x = (point.x * Math.cos((-1) * rotateStep * Math.PI/180)) + (point.y*Math.sin((-1)*rotateStep* (Math.PI/180)));
			point.y = (-1*point.x * Math.sin((-1)*rotateStep * Math.PI/180)) + (point.y*Math.cos((-1)*rotateStep* (Math.PI/180)));
			return point;
		});
		operationsMap.put("Przekrzywienie LEWO", point -> {
			point.x = (point.x * Math.cos( rotateStep * Math.PI/180)) + (point.y*Math.sin(rotateStep* (Math.PI/180)));
			point.y = (-1*point.x * Math.sin(rotateStep * Math.PI/180)) + (point.y*Math.cos(rotateStep* (Math.PI/180)));
			return point;
		});
		operationsMap.put("Zoom +", point -> {
			Rzut.d += zoomStep;
			return point;
		});
		operationsMap.put("Zoom -", point -> {
			Rzut.d -= zoomStep;
			return point;
		});
	}
}
