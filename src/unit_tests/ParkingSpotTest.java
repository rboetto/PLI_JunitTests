package unit_tests;


import java.io.PrintWriter;
import java.io.BufferedReader;
import java.lang.reflect.Field;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import server.controller.FacultyUser;
import server.controller.FiuParkingUser;
import server.controller.GuestUser;
import server.controller.HandicappedUser;
import server.controller.StudentUser;
import server.storage.ParkingSpot;

public class ParkingSpotTest {
	
	private ParkingSpot psTest;
	@Mock
	private PrintWriter pwMock;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		psTest = null;
	}

	@Test
	public void testParkingSpot() {
		fail("Not yet implemented");
	}

	@Test
	public void UT_PS_APS001() {
		
		// ParkingUser Test Data
		String testName = "Jane Doe";
		String testPid = "1234567";
		
		// ParkingSpot Test Data:
		int parkingSpot = 248742;
		String parkingType = "Student";
		int floor = 1;
		String parkingNumber = "102";
		String direction = "North";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
		
		// Preconditions:
		FiuParkingUser fpuMock = Mockito.mock(FiuParkingUser.class);
		Mockito.when(fpuMock.getName()).thenReturn(testName);
		Mockito.when(fpuMock.getUserID()).thenReturn(testPid);
		
		// Execute:
		psTest.assignParkingSpot(fpuMock);
		
		// Assert:
		FiuParkingUser ref = (FiuParkingUser) psTest.getUser();
		assertEquals(testName, ref.getName());
		assertEquals(testPid, ref.getUserID());
		
	}
	
	@Test
	public void UT_PS_APS002() {
		
		// FacultyUser Test Data
		String testName = "Ron Swanson";
		String testPid = "2547687";
		
		// ParkingSpot Test Data:
		int parkingSpot = 248742;
		String parkingType = "Faculty";
		int floor = 2;
		String parkingNumber = "242";
		String direction = "South";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
		
		// Preconditions:
		FacultyUser fpuMock = Mockito.mock(FacultyUser.class);
		Mockito.when(fpuMock.getName()).thenReturn(testName);
		Mockito.when(fpuMock.getUserID()).thenReturn(testPid);
		Mockito.when(fpuMock.toString()).thenReturn("Faculty");
		
		// Execute:
		psTest.assignParkingSpot(fpuMock);
		
		// Assert:
		FacultyUser ref = (FacultyUser) psTest.getUser();
		assertEquals(testName, ref.getName());
		assertEquals(testPid, ref.getUserID());
		assertEquals("Faculty", ref.toString());

	}
	
	@Test
	public void UT_PS_APS003() {
		
		// ParkingSpot Test Data:
		int parkingSpot = 4256555;
		String parkingType = "Guest";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
		
		// Preconditions:
		GuestUser fpuMock = Mockito.mock(GuestUser.class);
		Mockito.when(fpuMock.toString()).thenReturn("Guest");
		
		// Execute:
		psTest.assignParkingSpot(fpuMock);
		
		// Assert:
		GuestUser ref = (GuestUser) psTest.getUser();
		assertEquals("Guest", ref.toString());

	}
	
	@Test
	public void UT_PS_APS004() {
		
		// ParkingSpot Test Data:
		int parkingSpot = 5050566;
		String parkingType = "Handicapped";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
		
		// Preconditions:
		HandicappedUser fpuMock = Mockito.mock(HandicappedUser.class);
		Mockito.when(fpuMock.toString()).thenReturn("Handicapped");
		
		// Execute:
		psTest.assignParkingSpot(fpuMock);
		
		// Assert:
		HandicappedUser ref = (HandicappedUser) psTest.getUser();
		assertEquals("Handicapped", ref.toString());

	}


	@Test
	public void UT_PS_APS005() {
		
		// StudentUser Test Data
		String testName = "Bart Simpson";
		String testPid = "8745654";
		
		// ParkingSpot Test Data:
		int parkingSpot = 5050566;
		String parkingType = "Student";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
		
		// Preconditions:
		StudentUser fpuMock = Mockito.mock(StudentUser.class);
		Mockito.when(fpuMock.getName()).thenReturn(testName);
		Mockito.when(fpuMock.getUserID()).thenReturn(testPid);
		Mockito.when(fpuMock.toString()).thenReturn("Student");
		
		// Execute:
		psTest.assignParkingSpot(fpuMock);
		
		// Assert:
		StudentUser ref = (StudentUser) psTest.getUser();
		assertEquals(ref.getName(), testName);
		assertEquals(ref.getUserID(), testPid);
		assertEquals("Student", ref.toString());

	}


	@Test
	public void testRemoveAssignedUser_001_FIU() {
		
		// ParkingUser Test Data
		String testName = "Jane Doe";
		String testPid = "1234567";
				
		// ParkingSpot Test Data:
		int parkingSpot = 248742;
		String parkingType = "Student";
		int floor = 1;
		String parkingNumber = "102";
		String direction = "North";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
			
		// Preconditions:
		FiuParkingUser fpuMock = Mockito.mock(FiuParkingUser.class);
		Mockito.when(fpuMock.getName()).thenReturn(testName);
		Mockito.when(fpuMock.getUserID()).thenReturn(testPid);
		psTest.assignParkingSpot(fpuMock);
		
		// Execute:
		psTest.removeAssignedUser();
		
		// Assert:
		assertEquals(null, psTest.getUser());
	}
	
	@Test
	public void testRemoveAssignedUser_002_Faculty() {
		
		// FacultyUser Test Data
		String testName = "Ron Swanson";
		String testPid = "2547687";
		
		// ParkingSpot Test Data:
		int parkingSpot = 248742;
		String parkingType = "Faculty";
		int floor = 2;
		String parkingNumber = "242";
		String direction = "South";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
			
		// Preconditions:
		FacultyUser fpuMock = Mockito.mock(FacultyUser.class);
		Mockito.when(fpuMock.getName()).thenReturn(testName);
		Mockito.when(fpuMock.getUserID()).thenReturn(testPid);
		Mockito.when(fpuMock.toString()).thenReturn("Faculty");
		psTest.assignParkingSpot(fpuMock);
		
		// Execute:
		psTest.removeAssignedUser();
		
		// Assert:
		assertEquals(null, psTest.getUser());
	}
	
	@Test
	public void testRemoveAssignedUser_003_Guest() {
		
		// ParkingSpot Test Data:
		int parkingSpot = 4256555;
		String parkingType = "Guest";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
			
		// Preconditions:
		GuestUser fpuMock = Mockito.mock(GuestUser.class);
		Mockito.when(fpuMock.toString()).thenReturn("Guest");
		psTest.assignParkingSpot(fpuMock);
		
		// Execute:
		psTest.removeAssignedUser();
		
		// Assert:
		assertEquals(null, psTest.getUser());
	}
	
	@Test
	public void testRemoveAssignedUser_004_Handicapped() {
		
		// ParkingSpot Test Data:
		int parkingSpot = 5050566;
		String parkingType = "Handicapped";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
			
		// Preconditions:
		HandicappedUser fpuMock = Mockito.mock(HandicappedUser.class);
		Mockito.when(fpuMock.toString()).thenReturn("Handicapped");
		psTest.assignParkingSpot(fpuMock);
		
		// Execute:
		psTest.removeAssignedUser();
		
		// Assert:
		assertEquals(null, psTest.getUser());
	}

	@Test
	public void testRemoveAssignedUser_005_Student() {
		
		// StudentUser Test Data
		String testName = "Bart Simpson";
		String testPid = "8745654";
		
		// ParkingSpot Test Data:
		int parkingSpot = 5050566;
		String parkingType = "Student";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
			
		// Preconditions:
		StudentUser fpuMock = Mockito.mock(StudentUser.class);
		Mockito.when(fpuMock.getName()).thenReturn(testName);
		Mockito.when(fpuMock.getUserID()).thenReturn(testPid);
		Mockito.when(fpuMock.toString()).thenReturn("Student");
		psTest.assignParkingSpot(fpuMock);
		
		// Execute:
		psTest.removeAssignedUser();
		
		// Assert:
		assertEquals(null, psTest.getUser());
	}

	@Test
	public void testGetUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetParkingSpot() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetParkingNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFloor() {
		
		
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrintWriter() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPrintWriter() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDirections() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsConnected() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsAvailable() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetParkingType() {
		fail("Not yet implemented");
	}

}
