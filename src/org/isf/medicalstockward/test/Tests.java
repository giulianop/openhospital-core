package org.isf.medicalstockward.test;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.isf.supplier.model.Supplier;
import org.isf.supplier.test.TestSupplier;
import org.isf.supplier.test.TestSupplierContext;
import org.isf.utils.db.DbJpaUtil;
import org.isf.utils.exception.OHException;
import org.isf.ward.model.Ward;
import org.isf.ward.test.TestWard;
import org.isf.ward.test.TestWardContext;
import org.isf.medicals.model.Medical;
import org.isf.medstockmovtype.model.MovementType;
import org.isf.medstockmovtype.test.TestMovementType;
import org.isf.medstockmovtype.test.TestMovementTypeContext;
import org.isf.medtype.model.MedicalType;
import org.isf.medtype.test.TestMedicalType;
import org.isf.medtype.test.TestMedicalTypeContext;
import org.isf.medicals.test.TestMedical;
import org.isf.medicals.test.TestMedicalContext;
import org.isf.medicalstock.model.Lot;
import org.isf.medicalstock.model.Movement;
import org.isf.medicalstock.test.TestLot;
import org.isf.medicalstock.test.TestLotContext;
import org.isf.medicalstock.test.TestMovement;
import org.isf.medicalstock.test.TestMovementContext;
import org.isf.medicalstockward.model.MedicalWard;
import org.isf.medicalstockward.model.MedicalWardId;
import org.isf.medicalstockward.model.MovementWard;
import org.isf.medicalstockward.service.MedicalStockWardIoOperations;
import org.isf.patient.model.Patient;
import org.isf.patient.test.TestPatient;
import org.isf.patient.test.TestPatientContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test; 

public class Tests  
{
	private static DbJpaUtil jpa;
	private static TestMedical testMedical;
	private static TestMedicalContext testMedicalContext;
	private static TestMedicalType testMedicalType;
	private static TestMedicalTypeContext testMedicalTypeContext;
	private static TestWard testWard;
	private static TestWardContext testWardContext;
	private static TestMedicalWard testMedicalWard;
	private static TestMedicalWardContext testMedicalWardContext;
	private static TestPatient testPatient;
	private static TestPatientContext testPatientContext;
	private static TestMovementWard testMovementWard;
	private static TestMovementWardContext testMovementWardContext;
	private static TestMovement testMovement;
	private static TestMovementContext testMovementContext;
	private static TestMovementType testMovementType;
	private static TestMovementTypeContext testMovementTypeContext;
	private static TestSupplier testSupplier;
	private static TestSupplierContext testSupplierContext;
	private static TestLot testLot;
	private static TestLotContext testLotContext;
		
	
	@BeforeClass
    public static void setUpClass()  
    {
    	jpa = new DbJpaUtil();
    	testMedical = new TestMedical();
    	testMedicalContext = new TestMedicalContext();
    	testMedicalType = new TestMedicalType();
    	testMedicalTypeContext = new TestMedicalTypeContext();
    	testWard = new TestWard();
    	testWardContext = new TestWardContext();
    	testMedicalWard = new TestMedicalWard();
    	testMedicalWardContext = new TestMedicalWardContext();
    	testPatient = new TestPatient();
    	testPatientContext = new TestPatientContext();
    	testMovementWard = new TestMovementWard();
    	testMovementWardContext = new TestMovementWardContext();
    	testMovement = new TestMovement();
    	testMovementContext = new TestMovementContext();
    	testMovementType = new TestMovementType();
    	testMovementTypeContext = new TestMovementTypeContext();
    	testSupplier = new TestSupplier();
    	testSupplierContext = new TestSupplierContext();
    	testLot = new TestLot();
    	testLotContext = new TestLotContext();
    	
        return;
    }

    @Before
    public void setUp() throws OHException
    {
        jpa.open();
        
        _saveContext();
		
		return;
    }
        
    @After
    public void tearDown() throws Exception 
    {
        _restoreContext();   
        
        jpa.flush();
        jpa.close();
                
        return;
    }
    
    @AfterClass
    public static void tearDownClass() throws OHException 
    {
    	jpa.destroy();

    	return;
    }
	
	
	@Test
	public void testMedicalWardGets() 
	{
		MedicalWardId id = null;
			
		
		try 
		{		
			id = _setupTestMedicalWard(false);
			_checkMedicalWardIntoDb(id);
		} 
		catch (Exception e) 
		{
			System.out.println("Test Exception" + e);		
			assertEquals(true, false);
		}
				
		return;
	}
	
	@Test
	public void testMedicalWardSets() 
	{
		MedicalWardId id = null;
			
		
		try 
		{		
			id = _setupTestMedicalWard(true);
			_checkMedicalWardIntoDb(id);
		} 
		catch (Exception e) 
		{
			System.out.println("Test Exception" + e);		
			assertEquals(true, false);
		}
		
		return;
	}
	
	@Test
	public void testMovemetnWardGets() 
	{
		int id = 0;
			
		
		try 
		{		
			id = _setupTestMovementWard(false);
			_checkMovemetnWardIntoDb(id);
		} 
		catch (Exception e) 
		{
			System.out.println("Test Exception" + e);		
			assertEquals(true, false);
		}
				
		return;
	}
	
	@Test
	public void testMovemetnWardSets() 
	{
		int id = 0;
			
		
		try 
		{		
			id = _setupTestMovementWard(true);
			_checkMovemetnWardIntoDb(id);
		} 
		catch (Exception e) 
		{
			System.out.println("Test Exception" + e);		
			assertEquals(true, false);
		}
		
		return;
	}
	
	@Test
	public void testIoGetWardMovements() 
	{
		int code = 0;
		MedicalStockWardIoOperations ioOperations = new MedicalStockWardIoOperations();
		GregorianCalendar now = new GregorianCalendar();
		GregorianCalendar fromDate = new GregorianCalendar(now.get(Calendar.YEAR), 1, 1);
		GregorianCalendar toDate = new GregorianCalendar(now.get(Calendar.YEAR), 3, 3);
		
		
		try 
		{		
			code = _setupTestMovementWard(false);
			MovementWard foundMovement = (MovementWard)jpa.find(MovementWard.class, code); 
			ArrayList<MovementWard> movements = ioOperations.getWardMovements(
					foundMovement.getWard().getCode(),
					fromDate,
					toDate);

			assertEquals(foundMovement.getCode(), movements.get(0).getCode());
		} 
		catch (Exception e) 
		{
			System.out.println("Test Exception" + e);		
			assertEquals(true, false);
		}
		
		return;
	}
	
	@Test
	public void testIoGetCurrentQuantity() 
	{
		MedicalStockWardIoOperations ioOperations = new MedicalStockWardIoOperations();
		
		
		try 
		{		
			MedicalType medicalType = testMedicalType.setup(false);
			Medical medical= testMedical.setup(medicalType, false);
			Ward ward = testWard.setup(false);
			Patient patient = testPatient.setup(false);
			MovementType movementType = testMovementType.setup(false);
			Lot lot = testLot.setup(false);
			Supplier supplier = testSupplier.setup(false);		
			
		
			jpa.beginTransaction();	
			jpa.persist(medicalType);
			jpa.persist(medical);
			jpa.persist(ward);
			jpa.persist(patient);
			MovementWard movementWard = testMovementWard.setup(ward, patient, medical, false);
			jpa.persist(movementWard);
			jpa.persist(supplier);
			jpa.persist(lot);
			movementType.setCode("discharge");
			jpa.persist(movementType);
			Movement movement = testMovement.setup(medical, movementType, ward, lot, supplier, false);
			jpa.persist(movement);
			jpa.commitTransaction();
			
			int quantity = ioOperations.getCurrentQuantity(
					ward,
					medical);

			assertEquals(-46, quantity);
		} 
		catch (Exception e) 
		{
			System.out.println("Test Exception" + e);		
			assertEquals(true, false);
		}
		
		return;
	}
	
	@Test
	public void testIoNewMovementWard() 
	{
		MedicalStockWardIoOperations ioOperations = new MedicalStockWardIoOperations();
		boolean result = false;
		
		
		try 
		{		
			MovementWard movementWard;
			MedicalType medicalType = testMedicalType.setup(false);
			Medical medical= testMedical.setup(medicalType, false);
			Ward ward = testWard.setup(false);
			Patient patient = testPatient.setup(false);
			
		
			jpa.beginTransaction();	
			jpa.persist(medicalType);
			jpa.persist(medical);
			jpa.persist(ward);
			jpa.persist(patient);
			jpa.commitTransaction();
			movementWard = testMovementWard.setup(ward, patient, medical, false);
			result = ioOperations.newMovementWard(movementWard);
			
			assertEquals(true, result);
			_checkMovemetnWardIntoDb(movementWard.getCode());
		} 
		catch (Exception e) 
		{
			System.out.println("Test Exception" + e);		
			assertEquals(true, false);
		}
		
		return;
	}
	
	@Test
	public void testIoUpdateMovementWard()
	{
		int code = 0;
		MedicalStockWardIoOperations ioOperations = new MedicalStockWardIoOperations();
		boolean result = false;
		
		
		try 
		{		
			code = _setupTestMovementWard(false);
			MovementWard foundMovementWard = (MovementWard)jpa.find(MovementWard.class, code); 
			foundMovementWard.setDescription("Update");
			result = ioOperations.updateMovementWard(foundMovementWard);
			MovementWard updateMovementWard = (MovementWard)jpa.find(MovementWard.class, code); 
			
			assertEquals(true, result);
			assertEquals("Update", updateMovementWard.getDescription());
		} 
		catch (Exception e) 
		{
			System.out.println("Test Exception" + e);		
			assertEquals(true, false);
		}
		
		return;
	}

	@Test
	public void testIoDeleteMovementWard() 
	{
		int code = 0;
		MedicalStockWardIoOperations ioOperations = new MedicalStockWardIoOperations();
		boolean result = false;
		

		try 
		{		
			code = _setupTestMovementWard(false);
			MovementWard foundMovementWard = (MovementWard)jpa.find(MovementWard.class, code); 
			result = ioOperations.deleteMovementWard(foundMovementWard);
			
			assertEquals(true, result);
			MovementWard deletedMovementWard = (MovementWard)jpa.find(MovementWard.class, code); 
			assertEquals(null, deletedMovementWard);
		} 
		catch (Exception e) 
		{
			System.out.println("Test Exception" + e);		
			assertEquals(true, false);
		}
		
		return;
	}
	
	@Test
	public void testIoGetMedicalsWard()
	{
		MedicalWardId code = new MedicalWardId();
		MedicalStockWardIoOperations ioOperations = new MedicalStockWardIoOperations();
		
		
		try 
		{		
			code = _setupTestMedicalWard(false);
			MedicalWard foundMedicalWard = (MedicalWard)jpa.find(MedicalWard.class, code); 
			ArrayList<MedicalWard> medicalWards = ioOperations.getMedicalsWard(foundMedicalWard.getId().getWardId());

			assertEquals(foundMedicalWard.getInQuantity()-foundMedicalWard.getOutQuantity(), medicalWards.get(0).getQty());
		} 
		catch (Exception e) 
		{
			System.out.println("Test Exception" + e);		
			assertEquals(true, false);
		}
		
		return;
	}
	
	
	private void _saveContext() throws OHException 
    {	
		testMovementWardContext.saveAll(jpa);
		testMedicalContext.saveAll(jpa);
		testMedicalTypeContext.saveAll(jpa);
		testWardContext.saveAll(jpa);
		testMedicalWardContext.saveAll(jpa);
		testPatientContext.saveAll(jpa);
		testMovementContext.saveAll(jpa);
    	testMovementTypeContext.saveAll(jpa);
    	testSupplierContext.saveAll(jpa);
		testLotContext.saveAll(jpa);
		
        return;
    }
	
    private void _restoreContext() throws OHException 
    {
		System.out.println(testMedicalWardContext.getAllSaved());
		System.out.println(testMovementWardContext.getAllSaved());
		testMovementWardContext.deleteNews(jpa);
		testMovementContext.deleteNews(jpa);
		testMedicalWardContext.deleteNews(jpa);
		testMedicalContext.deleteNews(jpa);
		testLotContext.deleteNews(jpa);
		testMedicalTypeContext.deleteNews(jpa);
		testWardContext.deleteNews(jpa);
		testPatientContext.deleteNews(jpa);
    	testMovementTypeContext.deleteNews(jpa);
    	testSupplierContext.deleteNews(jpa);
        
        return;
    }
    
	private MedicalWardId _setupTestMedicalWard(
			boolean usingSet) throws OHException 
	{
		MedicalWard medicalWard;
		MedicalType medicalType = testMedicalType.setup(false);
		Medical medical= testMedical.setup(medicalType, false);
		Ward ward = testWard.setup(false);
		
	
		jpa.beginTransaction();	
		jpa.persist(medicalType);
		jpa.persist(medical);
		jpa.persist(ward);
		medicalWard = testMedicalWard.setup(medical, ward, usingSet);
		jpa.persist(medicalWard);
		jpa.commitTransaction();
		
		return medicalWard.getId();
	}
		
	private void  _checkMedicalWardIntoDb(
			MedicalWardId id) throws OHException 
	{
		MedicalWard foundMedicalWard;
		
	
		foundMedicalWard = (MedicalWard)jpa.find(MedicalWard.class, id); 
		testMedicalWard.check(foundMedicalWard);
		
		return;
	}	
    
	private int _setupTestMovementWard(
			boolean usingSet) throws OHException 
	{
		MovementWard movementWard;
		MedicalType medicalType = testMedicalType.setup(false);
		Medical medical= testMedical.setup(medicalType, false);
		Ward ward = testWard.setup(false);
		Patient patient = testPatient.setup(false);
		
	
		jpa.beginTransaction();	
		jpa.persist(medicalType);
		jpa.persist(medical);
		jpa.persist(ward);
		jpa.persist(patient);
		movementWard = testMovementWard.setup(ward, patient, medical, usingSet);
		jpa.persist(movementWard);
		jpa.commitTransaction();
		
		return movementWard.getCode();
	}
		
	private void  _checkMovemetnWardIntoDb(
			int id) throws OHException 
	{
		MovementWard foundMovementWard;
		
	
		foundMovementWard = (MovementWard)jpa.find(MovementWard.class, id); 
		testMovementWard.check(foundMovementWard);
		
		return;
	}	
}