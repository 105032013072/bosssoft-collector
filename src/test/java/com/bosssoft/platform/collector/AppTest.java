package com.bosssoft.platform.collector;

import org.junit.Test;

import com.bosssoft.platform.license.impl.LicenseUtil;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    @Test 
    public void test(){
        
        String str="gs7Ja4Q7FhVmSOZqIAhAXOW65vOtGeiZX2Cl6psfpzwBU6L0YUavMOcCGvI1aPzavyfVY3GNaWJJc5W2fSrntCXRuddEbgb7ePNepFvPR5cfcgrw+W20ete8SfCA1NJoDQz1/KfONZnxeomLHjTnuyfYSRtn+Kdw8hvH9T6FXdu8uD8d0zkjAD5BLCR5KdkHsxFWoIkJg8vXq9WVzseuWKjAedpxLFaqJSjM0vRdZ0+Cr59q+dHJK8o=";
       System.out.println(LicenseUtil.decrypt(str)); 
    }
}
