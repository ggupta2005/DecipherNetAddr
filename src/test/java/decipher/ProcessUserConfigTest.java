package decipher;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for ProcessUserConfig class.
 */
public class ProcessUserConfigTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ProcessUserConfigTest ()
    {
        super("ProcessUserConfigTest");
    }

    public void test_get_byte_radix () 
    {
        assertEquals("The unit value should be a valid binary value",
                     NetworkAddrRadix.BINARY,
                     ProcessUserConfig.get_byte_radix(
                                    "11110001", 
                                    ProcessUserConfig.IPV4_ADDR_BYTE_MIN,
                                    ProcessUserConfig.IPV4_ADDR_BYTE_MAX)); 

        assertEquals("The unit value should be a valid binary value",
                     NetworkAddrRadix.BINARY,
                     ProcessUserConfig.get_byte_radix(
                                    "11111111", 
                                    ProcessUserConfig.IPV4_ADDR_BYTE_MIN,
                                    ProcessUserConfig.IPV4_ADDR_BYTE_MAX)); 

        assertEquals("The unit value should not be a valid binary value",
                     NetworkAddrRadix.INVALID,
                     ProcessUserConfig.get_byte_radix(
                                    "111111111", 
                                    ProcessUserConfig.IPV4_ADDR_BYTE_MIN,
                                    ProcessUserConfig.IPV4_ADDR_BYTE_MAX)); 
    }

    public void test_validate_ipv4_address_number_format ()
    {
        /*
         * Test cases for decimal number
         */
        assertEquals("The number string should be a valid IPv4 address string",
                     NetworkAddrRadix.DECIMAL, 
                     ProcessUserConfig.validate_ipv4_address_number_format(
                                            Integer.toString(Integer.MAX_VALUE)));

        assertEquals("The number string should be a valid IPv4 address string",
                     NetworkAddrRadix.BINARY, 
                     ProcessUserConfig.validate_ipv4_address_number_format(
                                            Integer.toString(0)));

        assertEquals("The number string should not be a valid IPv4 address string",
                     NetworkAddrRadix.INVALID, 
                     ProcessUserConfig.validate_ipv4_address_number_format(
                                            Integer.toString(Integer.MIN_VALUE)));

        /*
         * Test cases for hexadecimal number
         */
        /*
        assertEquals("The number string should be a valid IPv4 address string",
                     NetworkAddrRadix.HEXADECIMAL, 
                     ProcessUserConfig.validate_ipv4_address_number_format("ffffffff"));
        */

        assertEquals("The number string should be a valid IPv4 address string",
                     NetworkAddrRadix.BINARY, 
                     ProcessUserConfig.validate_ipv4_address_number_format("0"));

    }

    public void test_validate_ipv4_address_dotted_format ()
    {
        /*
         * Test cases for decimal dotted IP address string
         */
        
        assertEquals("The number string should be a valid dotted IPv4 address string",
                     NetworkAddrRadix.DECIMAL, 
                     ProcessUserConfig.validate_ipv4_address_dotted_format(
                                                                    "255.255.255.255"));

        assertEquals("The number string should be a valid dotted IPv4 address string",
                     NetworkAddrRadix.DECIMAL, 
                     ProcessUserConfig.validate_ipv4_address_dotted_format(
                                                                    "0.0.0.0"));
    }
}