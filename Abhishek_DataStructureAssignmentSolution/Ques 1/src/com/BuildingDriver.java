package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.great.Building;

public class BuildingDriver {

	private final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter the total no of floors in the building");
		int floorSize = sc.nextInt();
		Queue<ArrayList<Integer>> queue = new LinkedList<>();
		ArrayList<Integer> floorsDeliveredTillDate = new ArrayList<>(floorSize);
		Building building = new Building();
		building.setFloorSize(floorSize);
		building.setPendingFloors(floorSize);
		int i = 1;
		while (i <= floorSize) {
			System.out.println("enter the floor size given on day : " + i);
			int floorNo = sc.nextInt();
			floorsDeliveredTillDate.add(floorNo);
			ArrayList<Integer> floorsDelivered = new ArrayList<>(floorsDeliveredTillDate);
			Collections.sort(floorsDelivered, Collections.reverseOrder());
			queue.add(floorsDelivered);
			i++;
		}

		for (int day = 1; day <= floorSize; day++) {
			int floorPending = building.getPendingFloors();
			ArrayList<Integer> flooronday = (ArrayList<Integer>) queue.remove();
			StringBuilder sb = new StringBuilder();
			for (int k = 0; k < flooronday.size(); k++) {
				if (flooronday.get(k) != null && flooronday.get(k) == floorPending) {
					sb.append(floorPending);
					sb.append(" ");
					floorPending--;
				}

			}
			System.out.println("Day: " + day);
			System.out.println(sb.toString());
			building.setPendingFloors(floorPending);

		}

	}

}
