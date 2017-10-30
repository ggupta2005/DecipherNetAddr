package decipher;

enum NetworkAddrRadix {BINARY, DECIMAL, HEXADECIMAL, INVALID};

public class ProcessUserConfig
{
    public static final int NUM_BINARY_SYSTEM_SYMBOLS = 2;
    public static final int NUM_DECIMAL_SYSTEM_SYMBOLS = 10;
    public static final int NUM_HEXADECIMAL_SYSTEM_SYMBOLS = 16;

    public static final int NUM_BYTES_IPV4_DOTTED_ADDR = 4;
    public static final int IPV4_ADDR_BYTE_MIN = 0;
    public static final int IPV4_ADDR_BYTE_MAX = 255;

    public static final int NUM_BYTES_ETHERNET_DOTTED_ADDR = 6;
    public static final int ETHERNET_ADDR_BYTE_MIN = 0;
    public static final int ETHERNET_ADDR_BYTE_MAX = 255;

    public static final int NUM_BYTES_IPV6_DOTTED_ADDR = 8;
    public static final int IPV6_ADDR_BYTE_MIN = 0;
    public static final int IPV6_ADDR_BYTE_MAX = 65535;

    public static NetworkAddrRadix validate_ipv4_address_number_format (
                                                            String ipv4_addr_num_str)
    {
        int ipv4_addr_num;

        if (ipv4_addr_num_str == null || ipv4_addr_num_str.length() == 0) {
            return(NetworkAddrRadix.INVALID);
        }

        /*
         * Test for binary valued unit
         */
        try {
            ipv4_addr_num = Integer.parseInt(ipv4_addr_num_str, NUM_BINARY_SYSTEM_SYMBOLS);

            if (ipv4_addr_num < 0) {
                return(NetworkAddrRadix.INVALID);
            } else {
                return(NetworkAddrRadix.BINARY);
            }
        } catch (NumberFormatException num_fmt_except) {

        }

        /*
         * Test for decimal valued unit
         */
        try {
            ipv4_addr_num = Integer.parseInt(ipv4_addr_num_str, NUM_DECIMAL_SYSTEM_SYMBOLS);

            if (ipv4_addr_num < 0) {
                return(NetworkAddrRadix.INVALID);
            } else {
                return(NetworkAddrRadix.DECIMAL);
            }
        } catch (NumberFormatException num_fmt_except) {

        }

        /*
         * Test for hexadecimal valued unit
         */
        try {
            ipv4_addr_num = Integer.parseInt(ipv4_addr_num_str, NUM_HEXADECIMAL_SYSTEM_SYMBOLS);

            if (ipv4_addr_num < 0) {
                return(NetworkAddrRadix.INVALID);
            } else {
                return(NetworkAddrRadix.HEXADECIMAL);
            }
        } catch (NumberFormatException num_fmt_except) {

        }

        return(NetworkAddrRadix.INVALID);
    }

    public static NetworkAddrRadix get_byte_radix (String unit_str, int unit_val_min,
                                                   int unit_val_max)
    {
        int unit_val;

        if (unit_str == null || unit_str.length() == 0 ||
            unit_val_min < 0 || unit_val_max < 0 || unit_val_min > unit_val_max) {
            return(NetworkAddrRadix.INVALID);
        }

        /*
         * Test for binary valued unit
         */
        try {
            unit_val = Integer.parseInt(unit_str, NUM_BINARY_SYSTEM_SYMBOLS);

            if (unit_val < unit_val_min || unit_val > unit_val_max) {
                return(NetworkAddrRadix.INVALID);
            } else {
                return(NetworkAddrRadix.BINARY);
            }
        } catch (NumberFormatException num_fmt_except) {

        }

        /*
         * Test for decimal valued unit
         */
        try {
            unit_val = Integer.parseInt(unit_str, NUM_DECIMAL_SYSTEM_SYMBOLS);

            if (unit_val < unit_val_min || unit_val > unit_val_max) {
                return(NetworkAddrRadix.INVALID);
            } else {
                return(NetworkAddrRadix.DECIMAL);
            }
        } catch (NumberFormatException num_fmt_except) {

        }

        /*
         * Test for hexadecimal valued unit
         */
        try {
            unit_val = Integer.parseInt(unit_str, NUM_HEXADECIMAL_SYSTEM_SYMBOLS);

            if (unit_val < unit_val_min || unit_val > unit_val_max) {
                return(NetworkAddrRadix.INVALID);
            } else {
                return(NetworkAddrRadix.HEXADECIMAL);
            }
        } catch (NumberFormatException num_fmt_except) {

        }

        return(NetworkAddrRadix.INVALID);
    }

    public static NetworkAddrRadix validate_ipv4_address_dotted_format (
                                                        String ipv4_addr_dotted_str)
    {
        String[] byte_array;

        if (ipv4_addr_dotted_str == null || ipv4_addr_dotted_str.length() == 0) {
            System.out.println("Return 1");
            return(NetworkAddrRadix.INVALID);
        }

        byte_array = ipv4_addr_dotted_str.split(".");

        if (byte_array == null ||
            byte_array.length < NUM_BYTES_IPV4_DOTTED_ADDR ||
            byte_array.length > NUM_BYTES_IPV4_DOTTED_ADDR) {
            System.out.println("Return 2");
            return(NetworkAddrRadix.INVALID);
        }

        NetworkAddrRadix ipv4_byte_radix = get_byte_radix(byte_array[0],
                                                          IPV4_ADDR_BYTE_MIN,
                                                          IPV4_ADDR_BYTE_MAX);
        for (int byte_index = 0; byte_index < byte_array.length; ++byte_index) {

            if (ipv4_byte_radix != get_byte_radix(byte_array[byte_index],
                                                  IPV4_ADDR_BYTE_MIN,
                                                  IPV4_ADDR_BYTE_MAX)) {
                return(NetworkAddrRadix.INVALID);
            }
        }

        System.out.println("Return 3");
        return(ipv4_byte_radix);
    }

    public static NetworkAddrRadix validate_ethernet_address_dotted_format (
                                                    String ether_addr_dotted_str)
    {
        String[] byte_array;

        if (ether_addr_dotted_str == null || ether_addr_dotted_str.length() == 0) {
            return(NetworkAddrRadix.INVALID);
        }

        byte_array = ether_addr_dotted_str.split(":");

        if (byte_array == null ||
            byte_array.length < NUM_BYTES_ETHERNET_DOTTED_ADDR ||
            byte_array.length > NUM_BYTES_ETHERNET_DOTTED_ADDR) {
            return(NetworkAddrRadix.INVALID);
        }

        NetworkAddrRadix ether_byte_radix = get_byte_radix(byte_array[0],
                                                          ETHERNET_ADDR_BYTE_MIN,
                                                          ETHERNET_ADDR_BYTE_MAX);
        for (int byte_index = 0; byte_index < byte_array.length; ++byte_index) {

            if (ether_byte_radix != get_byte_radix(byte_array[byte_index],
                                                   ETHERNET_ADDR_BYTE_MIN,
                                                   ETHERNET_ADDR_BYTE_MAX)) {
                return(NetworkAddrRadix.INVALID);
            }
        }

        return(ether_byte_radix);
    }

    public static NetworkAddrRadix validate_ipv6_address_dotted_format (
                                                        String ipv6_addr_dotted_str)
    {
        String[] byte_array;
        String[] split_array;
        String[] first_half_byte_array;
        String[] second_half_byte_array;

        if (ipv6_addr_dotted_str == null || ipv6_addr_dotted_str.length() == 0) {
            return(NetworkAddrRadix.INVALID);
        }

        split_array = ipv6_addr_dotted_str.split("::");

        if (split_array.length > 2) {
            return(NetworkAddrRadix.INVALID);
        }

        if (split_array.length == 0) {

            byte_array = ipv6_addr_dotted_str.split(":");

            if (byte_array == null ||
                byte_array.length < NUM_BYTES_IPV6_DOTTED_ADDR ||
                byte_array.length > NUM_BYTES_IPV6_DOTTED_ADDR) {
                return(NetworkAddrRadix.INVALID);
            }

            NetworkAddrRadix ipv6_byte_radix = get_byte_radix(byte_array[0],
                                                              IPV6_ADDR_BYTE_MIN,
                                                              IPV6_ADDR_BYTE_MAX);
            for (int byte_index = 0; byte_index < byte_array.length; ++byte_index) {

                if (ipv6_byte_radix != get_byte_radix(byte_array[byte_index],
                                                      IPV6_ADDR_BYTE_MIN,
                                                      IPV6_ADDR_BYTE_MAX)) {
                    return(NetworkAddrRadix.INVALID);
                }
            }

            return(ipv6_byte_radix);
        } else {

            first_half_byte_array = split_array[0].split(":");

            if (first_half_byte_array == null ||
                first_half_byte_array.length >= NUM_BYTES_IPV6_DOTTED_ADDR) {
                return(NetworkAddrRadix.INVALID);
            }

            NetworkAddrRadix first_half_ipv6_byte_radix =
                                    get_byte_radix(first_half_byte_array[0],
                                                   IPV6_ADDR_BYTE_MIN,
                                                   IPV6_ADDR_BYTE_MAX);

            for (int byte_index = 0; byte_index < first_half_byte_array.length;
                 ++byte_index) {

                if (first_half_ipv6_byte_radix != get_byte_radix(
                                                     first_half_byte_array[byte_index],
                                                     IPV6_ADDR_BYTE_MIN,
                                                     IPV6_ADDR_BYTE_MAX)) {

                    return(NetworkAddrRadix.INVALID);
                }
            }

            second_half_byte_array = split_array[1].split(":");

            if (second_half_byte_array == null ||
                second_half_byte_array.length >= NUM_BYTES_IPV6_DOTTED_ADDR) {
                return(NetworkAddrRadix.INVALID);
            }

            NetworkAddrRadix second_half_ipv6_byte_radix =
                                    get_byte_radix(second_half_byte_array[0],
                                                   IPV6_ADDR_BYTE_MIN,
                                                   IPV6_ADDR_BYTE_MAX);

            for (int byte_index = 0; byte_index < second_half_byte_array.length;
                 ++byte_index) {

                if (second_half_ipv6_byte_radix != get_byte_radix(
                                                     second_half_byte_array[byte_index],
                                                     IPV6_ADDR_BYTE_MIN,
                                                     IPV6_ADDR_BYTE_MAX)) {

                    return(NetworkAddrRadix.INVALID);
                }
            }

            if (second_half_ipv6_byte_radix != first_half_ipv6_byte_radix) {
                return(NetworkAddrRadix.INVALID);
            }

            if (second_half_byte_array.length + first_half_byte_array.length >
                                                      NUM_BYTES_IPV6_DOTTED_ADDR) {
                return(NetworkAddrRadix.INVALID);
            }

            return(second_half_ipv6_byte_radix);
        }

        //return(NetworkAddrRadix.INVALID);
    }

    public static void validate_and_populate_user_net_addr_str
                                                    (String net_addr_str,
                                                     UserConfig user_config)
    {
        NetworkAddrRadix net_addr_radix;

        if (net_addr_str == null || net_addr_str.length() == 0 ||
            user_config == null) {
            return;
        }

        net_addr_radix = validate_ipv4_address_number_format(net_addr_str);
        if (net_addr_radix != NetworkAddrRadix.INVALID) {
            user_config.set_NetAddrType(NetworkAddrType.IPV4);
            user_config.set_NetAddrRadix(net_addr_radix);
            return;
        }

        net_addr_radix = validate_ipv4_address_dotted_format(net_addr_str);
        if (net_addr_radix != NetworkAddrRadix.INVALID) {
            user_config.set_NetAddrType(NetworkAddrType.IPV4);
            user_config.set_NetAddrRadix(net_addr_radix);
            return;
        }

        net_addr_radix = validate_ethernet_address_dotted_format(net_addr_str);
        if (net_addr_radix != NetworkAddrRadix.INVALID) {
            user_config.set_NetAddrType(NetworkAddrType.ETHERNET);
            user_config.set_NetAddrRadix(net_addr_radix);
            return;
        }

        net_addr_radix = validate_ipv6_address_dotted_format(net_addr_str);
        if (net_addr_radix != NetworkAddrRadix.INVALID) {
            user_config.set_NetAddrType(NetworkAddrType.IPV6);
            user_config.set_NetAddrRadix(net_addr_radix);
            return;
        }
    }
}
