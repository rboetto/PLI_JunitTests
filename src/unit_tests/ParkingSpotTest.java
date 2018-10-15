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
	public void UT_PS_PS001() {
		
		// Preconditions
		// ParkingSpot Test Data:
		int parkingSpot = 5050566;
		String parkingType = "Student";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
				
		// Execute:
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
				
		// Assert:
		assertEquals(parkingSpot, psTest.getParkingSpot());
		assertEquals(parkingType, psTest.getParkingType());
		assertEquals(floor, psTest.getFloor());
		assertEquals(parkingNumber, psTest.getParkingNumber());
		assertEquals(direction, psTest.getDirections());
		
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
	public void UT_PS_RAU001() {
		
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
	public void UT_PS_RAU002() {
		
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
	public void UT_PS_RAU003() {
		
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
	public void UT_PS_RAU004() {
		
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
	public void UT_PS_RAU005() {
		
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
	public void UT_PS_GU001() {
		
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
		StudentUser studentUser = (StudentUser) psTest.getUser();
		
		// Assert:
		assertEquals(testName, studentUser.getName());
		assertEquals(testPid, studentUser.getUserID());
		
	}

	@Test
	public void UT_PS_GPS001() {
		
		//Preconditions
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
		
		// Assert:
		assertEquals(parkingSpot, psTest.getParkingSpot());
		
	}

	@Test
	public void UT_PS_GPN001() {
		
		//Preconditions
		// ParkingSpot Test Data:
		int parkingSpot = 5050566;
		String parkingType = "Student";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
		
		// Assert:
		assertEquals(parkingNumber, psTest.getParkingNumber());
		
	}

	@Test
	public void UT_PS_GF001() {
		
		//Preconditions	
		// ParkingSpot Test Data:
		int parkingSpot = 5050566;
		String parkingType = "Student";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
		
		// Assert:
		assertEquals(floor, psTest.getFloor());
		
	}

	@Test
	public void UT_PS_GPW001() {
		
		// ParkingSpot Test Data:
		int parkingSpot = 5050566;
		String parkingType = "Student";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
		
		// Preconditions:
		PrintWriter pWriterMock = Mockito.mock(PrintWriter.class);
		psTest.setPrintWriter(pWriterMock);
		
		// Execute:
		PrintWriter pWriterGet = psTest.getPrintWriter();
		
		// Assert:
		assertEquals(pWriterMock.toString(), pWriterGet.toString());
	}

	@Test
	public void UT_PS_SPW001() {	
		
		// ParkingSpot Test Data:
		int parkingSpot = 5050566;
		String parkingType = "Student";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
		
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
		
		// Preconditions:
		PrintWriter pWriterMock = Mockito.mock(PrintWriter.class);
		
		// Execute:
		psTest.setPrintWriter(pWriterMock);
		
		// Assert:
		assertEquals(pWriterMock, psTest.getPrintWriter());
	}
	
	@Test
	public void UT_PS_GD001() {
		
		// Preconditions
		// ParkingSpot Test Data:
		int parkingSpot = 5050566;
		String parkingType = "Student";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
				
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);	
				
		// Execute:
		String getDirection = psTest.getDirections();
				
		// Assert:
		assertEquals(direction, getDirection);
	}

	@Test
	public void UT_PS_IC001() {
		
		// ParkingSpot Test Data:
		int parkingSpot = 5050566;
		String parkingType = "Student";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
				
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
				
		// Preconditions:
		PrintWriter pWriterMock = Mockito.mock(PrintWriter.class);
				
		// Execute:
		psTest.setPrintWriter(pWriterMock);
				
		// Assert:
		assertEquals(true, psTest.isConnected());
	}

	@Test
	public void UT_PS_IC002() {
		// ParkingSpot Test Data:
		int parkingSpot = 5050566;
		String parkingType = "Student";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
				
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
				
		// Execute:
				
		// Assert:
		assertEquals(false, psTest.isConnected());
	}
	
	@Test
	public void UT_PS_IA001() {
		
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
		boolean isAvailable = psTest.isAvailable();
		
		// Assert:
		assertEquals(false, isAvailable);
	}
	
	@Test
	public void UT_PS_IA002() {
		
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
		psTest.removeAssignedUser();
		
		// Execute:
		boolean isAvailable = psTest.isAvailable();
		
		// Assert:
		assertEquals(true, isAvailable);
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
	public void UT_PS_GPT001() {
		
		//Preconditions
		// Parking Spot Test Data
		int parkingSpot = 5050566;
		String parkingType = "Student";
		int floor = 1;
		String parkingNumber = "150";
		String direction = "West";
				
		psTest = new ParkingSpot(parkingSpot, parkingType, floor, parkingNumber, direction);
				
		// Execute:
		String getParkingTypeTest = psTest.getParkingType();
				
		// Assert:
		assertEquals(parkingType, getParkingTypeTest);
	}
}
