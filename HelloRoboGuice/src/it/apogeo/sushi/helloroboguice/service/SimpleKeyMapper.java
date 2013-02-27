package it.apogeo.sushi.helloroboguice.service;

import it.apogeo.sushi.helloroboguice.R;
import it.apogeo.sushi.helloroboguice.service.Calculator.Control;
import it.apogeo.sushi.helloroboguice.service.Calculator.Digit;
import android.util.SparseArray;

/**
 * Simple implementation of the KeyMapper 
 * 
 * @author Massimo Carli - 29/ago/2012
 *
 */
public class SimpleKeyMapper implements KeyMapper{
	
	/*
	 * Mapper for the Control items
	 */
	private SparseArray<Control> controlMapper;
	
	/*
	 * Mapper for the Digit items
	 */
	private SparseArray<Digit> digitMapper;	
	
	/*
	 * Initialize a SimpleKeyMapper
	 */
	public SimpleKeyMapper(){
        // Create and initialize mappers
        controlMapper = new SparseArray<Calculator.Control>();
        controlMapper.put(R.id.key_plus_button, Control.CNT_ADD);
        controlMapper.put(R.id.key_minus_button, Control.CNT_SUB);
        controlMapper.put(R.id.key_canc_button, Control.CNT_CLR);
        controlMapper.put(R.id.key_result_button, Control.CNT_RES);
        digitMapper = new SparseArray<Calculator.Digit>();
        digitMapper.put(R.id.key_0_button, Digit.KEY_0);
        digitMapper.put(R.id.key_1_button, Digit.KEY_1);
        digitMapper.put(R.id.key_2_button, Digit.KEY_2);
        digitMapper.put(R.id.key_3_button, Digit.KEY_3);
        digitMapper.put(R.id.key_4_button, Digit.KEY_4);
        digitMapper.put(R.id.key_5_button, Digit.KEY_5);
        digitMapper.put(R.id.key_6_button, Digit.KEY_6);
        digitMapper.put(R.id.key_7_button, Digit.KEY_7);
        digitMapper.put(R.id.key_8_button, Digit.KEY_8);
        digitMapper.put(R.id.key_9_button, Digit.KEY_9);		
	}

	@Override
	public Digit digitForKey(int buttonId) {
		return digitMapper.get(buttonId);
	}

	@Override
	public Control controlForKey(int buttonId) {
		return controlMapper.get(buttonId);
	}

}
