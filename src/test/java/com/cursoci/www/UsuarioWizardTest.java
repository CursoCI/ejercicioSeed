package com.cursoci.www;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cursoci.www.entidades.Usuario;

import junit.framework.TestCase;

public class UsuarioWizardTest {
	
	UsuarioWizard userWizard;
	
	@BeforeClass
	public static void iniciar() {
		userWizard = new UsuarioWizard();
	}

	@Test
	public void testGetUser() {
		final Usuario user = userWizard.getUser();
		
		assertNotNull(user);
	}

	@Test
	public void testSetUser() {
		final Usuario user = new Usuario();
		userWizard.setUser(user);
		
		assertEquals(user, userWizard.getUser());
	}

	@Test
	public void testIsSkip() {
		assertEquals(userWizard.isSkip(), false);
	}

	@Test
	public void testSetSkip() {
		userWizard.setSkip(true);
		
		assertTrue(userWizard.isSkip());
	}
}
