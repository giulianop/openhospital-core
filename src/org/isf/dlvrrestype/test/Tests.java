package org.isf.dlvrrestype.test;


import static org.junit.Assert.assertEquals;

import org.isf.dlvrrestype.model.DeliveryResultType;
import org.isf.dlvrrestype.service.DeliveryResultTypeIoOperation;
import org.isf.utils.db.DbJpaUtil;
import org.isf.utils.exception.OHException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Tests  
{
	@Autowired
	private static DbJpaUtil jpa;
	private static TestDeliveryResultType testDeliveryResultType;
	private static TestDeliveryResultTypeContext testDeliveryResultTypeContext;
		
	
	@BeforeClass
    public static void setUpClass()  
    {
    	
    	testDeliveryResultType = new TestDeliveryResultType();
    	testDeliveryResultTypeContext = new TestDeliveryResultTypeContext();
    	
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
    	testDeliveryResultType = null;
    	testDeliveryResultTypeContext = null;

    	return;
    }
	
		
	@Test
	public void testDeliveryResultTypeGets()
	{
		String code = "";
			

		try 
		{		
			code = _setupTestDeliveryResultType(false);
			_checkDeliveryResultTypeIntoDb(code);
		} 
		catch (Exception e) 
		{
			System.out.println("==> Test Exception: " + e);		
			assertEquals(true, false);
		}
				
		return;
	}
	
	@Test
	public void testDeliveryResultTypeSets() 
	{
		String code = "";
			

		try 
		{		
			code = _setupTestDeliveryResultType(true);
			_checkDeliveryResultTypeIntoDb(code);
		} 
		catch (Exception e) 
		{
			System.out.println("==> Test Exception: " + e);		
			assertEquals(true, false);
		}
		
		return;
	}
	
	@Test
	public void testIoGetDeliveryResultType() 
	{
		String code = "";
		
		try 
		{		
			code = _setupTestDeliveryResultType(false);
			DeliveryResultType foundDeliveryResultType = (DeliveryResultType)jpa.find(DeliveryResultType.class, code); 
			
			assertEquals("TestDescription", foundDeliveryResultType.getDescription());
		} 
		catch (Exception e) 
		{
			System.out.println("==> Test Exception: " + e);		
			assertEquals(true, false);
		}
		
		return;
	}
	
	@Test
	public void testIoUpdateDeliveryResultType() 
	{
		String code = "";
		DeliveryResultTypeIoOperation ioOperations = new DeliveryResultTypeIoOperation();
		boolean result = false;
		
		
		try 
		{		
			code = _setupTestDeliveryResultType(false);
			DeliveryResultType foundDeliveryResultType = (DeliveryResultType)jpa.find(DeliveryResultType.class, code); 
			foundDeliveryResultType.setDescription("Update");
			result = ioOperations.updateDeliveryResultType(foundDeliveryResultType);
			DeliveryResultType updateDeliveryResultType = (DeliveryResultType)jpa.find(DeliveryResultType.class, code); 
			
			assertEquals(true, result);
			assertEquals("Update", updateDeliveryResultType.getDescription());
		} 
		catch (Exception e) 
		{
			System.out.println("==> Test Exception: " + e);		
			assertEquals(true, false);
		}
		
		return;
	}
	
	@Test
	public void testIoNewDeliveryResultType() 
	{
		DeliveryResultTypeIoOperation ioOperations = new DeliveryResultTypeIoOperation();
		boolean result = false;
		
		
		try 
		{		
			DeliveryResultType deliveryResultType = testDeliveryResultType.setup(true);
			result = ioOperations.newDeliveryResultType(deliveryResultType);
			
			assertEquals(true, result);
			_checkDeliveryResultTypeIntoDb(deliveryResultType.getCode());
		} 
		catch (Exception e) 
		{
			System.out.println("==> Test Exception: " + e);		
			assertEquals(true, false);
		}
		
		return;
	}

	@Test
	public void testIoDeleteDeliveryResultType() 
	{
		String code = "";
		DeliveryResultTypeIoOperation ioOperations = new DeliveryResultTypeIoOperation();
		boolean result = false;
		

		try 
		{		
			code = _setupTestDeliveryResultType(false);
			DeliveryResultType foundDeliveryResultType = (DeliveryResultType)jpa.find(DeliveryResultType.class, code); 
			result = ioOperations.deleteDeliveryResultType(foundDeliveryResultType);
			
			assertEquals(true, result);
			DeliveryResultType deletedDeliveryResultType = (DeliveryResultType)jpa.find(DeliveryResultType.class, code); 
			assertEquals(null, deletedDeliveryResultType);
		} 
		catch (Exception e) 
		{
			System.out.println("==> Test Exception: " + e);		
			assertEquals(true, false);
		}
		
		return;
	}

	@Test
	public void testIoIsCodePresent() 
	{
		String code = "";
		DeliveryResultTypeIoOperation ioOperations = new DeliveryResultTypeIoOperation();
		boolean result = false;
		

		try 
		{		
			code = _setupTestDeliveryResultType(false);
			result = ioOperations.isCodePresent(code);
			
			assertEquals(true, result);
		} 
		catch (Exception e) 
		{
			System.out.println("==> Test Exception: " + e);		
			assertEquals(true, false);
		}
		
		return;
	}
		
	
	private void _saveContext() throws OHException 
    {	
		testDeliveryResultTypeContext.saveAll(jpa);
        		
        return;
    }
	
    private void _restoreContext() throws OHException 
    {
		System.out.println(testDeliveryResultTypeContext.getAllSaved());
		testDeliveryResultTypeContext.deleteNews(jpa);
        
        return;
    }
        
	private String _setupTestDeliveryResultType(
			boolean usingSet) throws OHException 
	{
		DeliveryResultType deliveryResultType;
		

    	jpa.beginTransaction();	
    	deliveryResultType = testDeliveryResultType.setup(usingSet);
		jpa.persist(deliveryResultType);
    	jpa.commitTransaction();
    	
		return deliveryResultType.getCode();
	}
		
	private void  _checkDeliveryResultTypeIntoDb(
			String code) throws OHException 
	{
		DeliveryResultType foundDeliveryResultType;
		

		foundDeliveryResultType = (DeliveryResultType)jpa.find(DeliveryResultType.class, code); 
		testDeliveryResultType.check(foundDeliveryResultType);
		
		return;
	}	
}