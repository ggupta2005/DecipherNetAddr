package decipher;

enum NetworkAddrType {IPV4, ETHERNET, IPV6, INVALID};

public class UserConfig
{
    private String NetworkAddr;
    private NetworkAddrType NetAddrType;
    private NetworkAddrRadix NetAddrRadix;

    UserConfig (String network_addr, NetworkAddrType net_addr_type)
    {
        NetworkAddr = network_addr;
        NetAddrType = net_addr_type;
        NetAddrRadix = NetworkAddrRadix.INVALID;
    }

    public String get_NetworkAddr ()
    {
        return(NetworkAddr);
    }

    public NetworkAddrType get_NetAddrType ()
    {
        return(NetAddrType);
    }

    public NetworkAddrRadix get_NetAddrRadix ()
    {
        return(NetAddrRadix);
    }

    public void set_NetworkAddr (String network_addr)
    {
        NetworkAddr = network_addr;
    }

    public void set_NetAddrType (NetworkAddrType net_addr_type)
    {
        NetAddrType = net_addr_type;
    }

    public void set_NetAddrRadix (NetworkAddrRadix net_addr_radix)
    {
        NetAddrRadix = net_addr_radix;
    }
}
