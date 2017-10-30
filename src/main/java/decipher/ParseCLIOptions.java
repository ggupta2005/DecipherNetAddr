package decipher;

public class ParseCLIOptions
{
    public static UserConfig parse_cli_options (String[] args)
                                        throws NoCLIOptionsException,
                                               IllegalNetAddrException
    {
        UserConfig user_config;

        if (args.length == 0) {
            throw new NoCLIOptionsException();
        }

        user_config = new UserConfig(args[0], NetworkAddrType.INVALID);

        ProcessUserConfig.validate_and_populate_user_net_addr_str(args[0], user_config);

        if (user_config.get_NetAddrType() == NetworkAddrType.INVALID) {
            throw new IllegalNetAddrException();
        }

        return(user_config);
    }
}
