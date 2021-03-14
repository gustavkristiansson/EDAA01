package ext20190426;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class RoadMap {
	private Map<String, List<TownDistance>> map;
	
	
	public RoadMap(Map<String, List<TownDistance>> map) {
		this.map = map;
	}
	
	public void printTour(String startTown) {
		Set<String> visited = new HashSet<>();
		visited.add(startTown);
		System.out.println(startTown);
		
		int dist = 0;
		while(visited.size() < map.size()) {
			TownDistance t = closestUnvisited(startTown, visited);
			System.out.println(t.getDestination());
			dist += t.getDistance();
			visited.add(t.getDestination());
			startTown = t.getDestination();
		}
		System.out.println("Total resväg " + dist + " km");	
	}
	
	private TownDistance closestUnvisited(String startTown, Set<String> visited) {
		Iterator<TownDistance> itr = map.get(startTown).iterator();
		
		while(itr.hasNext()) {
			TownDistance t = itr.next();
			if(! visited.contains(t.getDestination())) {
				return t;
			}
		}
		return null;
	}

	
	PriorityQueue<TownDistance> q = new PriorityQueue<>((t1, t2) -> t1.getDistance() - t2.getDistance());
		
}
