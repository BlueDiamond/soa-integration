package com.bd.mule.esb.soai;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

public class SoaiTransformer extends AbstractTransformer {

	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		System.out.println("iam in, src: "+ src + ", enc: " + enc);
		if (src instanceof String) {
			String name = (String) src;
			
			if (name.contains("/")) {
				System.out.println("iam inside, name:" + name);
				return name.replaceAll("/", " ");
			}
		}
		return src;
	}
}
