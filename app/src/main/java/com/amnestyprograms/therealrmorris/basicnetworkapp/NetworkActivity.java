package com.amnestyprograms.therealrmorris.basicnetworkapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class NetworkActivity extends ActionBarActivity implements OnClickListener
{
    private TextView question, questionAnswers, decideAnswer;
    private Button answer, skip;
    private EditText edittext;
    private int wrongAnswers = 0, correctAnswers = 0, randomQuestion;
    private Random randQuestion = new Random();
    private String[] Chapter1, Chapter1Answers, Chapter1Choice;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        question = (TextView) findViewById(R.id.Question);
        questionAnswers = (TextView) findViewById(R.id.QuestionAnswers);
        decideAnswer = (TextView) findViewById(R.id.DecideAnswer);
        answer = (Button) findViewById(R.id.Answer);
        skip = (Button) findViewById(R.id.Skip);
        edittext = (EditText) findViewById(R.id.editText);

        answer.setOnClickListener(this);
        skip.setOnClickListener(this);

        decideAnswer.setText("");
        answer.setText("Submit");

        int randomQuestion;
        Random randQuestion = new Random();

        randomQuestion = randQuestion.nextInt(102);

            //These are the literal questions in the book.
            Chapter1 = new String[] { "What should be enabled on a computer that has direct connection to the\n" +
                    "Internet?",
                    "True or False. A WAP often provides access to the Internet",
                    "A group of computers are connected in a single location. What is this called?",
                    "A network is connected using high-speed components rated at 1 GBPS. What does the b represent in GBPS?",
                    "Users in the network have to remember an average of five usernames and passwords\n" +
                            "to access different computers. How can you reduce the number of passwords remembered\n" +
                            "by users?",
                    "Define a LAN.",
                    "Define a WAN.",
                    "An employee is able to connect to the employer's private network over the Internet. What is the employee using?",
                    "What are two types of remote access servers? (Choose two)",
                    "True or False. All RFCs are known standards.",
                    //At this point this is Chapter 2 (10 extra questions)
                    "What type of traffic always goes to all devices in a subnet?",
                    "True or False. A switch blocks broadcasts.",
                    "What is the difference between a switch and a router?",
                    "True or False. Bridges can connect dissimilar physical topologies.",
                    "A firewall uses _______ to filter both inbound and outbound traffic.",
                    "A network-based firewall is a hardware device that provides protection for a network. What is a host-based firewall?",
                    "True or False. A crossover cable is used to connect a computer to a switch.",
                    "Which of the following standards define how twisted-pair cables should be wired?",
                    "A company wants to host a web server for Internet users. The web server should be placed in ____.",
                    "What is used to provide access to a company's resources via the Internet to trusted partners?",
                    //At this point this is Chapter 3 (10 extra questions)
                    "The OSI Model has _______ layers.",
                    "Write down a mnemonic you use to remember the OSI Model.",
                    "True or False. TCP is a connectionless protocol.",
                    "What is a unit of data called at the Transport layer?",
                    "Which of the following could be a valid MAC address for a server named Server 1?",
                    "IPv4 operates on the _________ layer of the OSI Model.",
                    "List the protocols that operate on the Transport layer of the OSI Model.",
                    "True or False. Devices that operate on layer 7 of the OSI Model are more intelligent that devices that operate on layer 1.",
                    "Routers operate on which of the following layers of the OSI Model?",
                    "Proxy servers operate on which of the following layers of the OSI Model?",
                    //At this point this is Chapter 4 (10 extra questions)
                    "Which of the following protocols is considered connection-orientated?",
                    "True or False. UDP traffic accepts the loss of some data.",
                    "What type of traffic commonly uses UDP? (Choose all that apply)",
                    "What is used to resolve an IP address to a MAC address?",
                    "List three commonly used protocols for email.",
                    "L2TP is one of many tunnelling protocols used for VPNs. What is used to encrypt L2TP traffic?",
                    "The _______ protocol is used to manage multicast transmissions.",
                    "What port is used by RDS",
                    "What port is used by LDAP?",
                    "What port is used by Kerberos?",
                    //At this point this is Chapter 5 (10 extra questions)
                    "Which of the following addresses is a valid IPv4 address?",
                    "What class is the following IP address: 192.168.1.5?",
                    "True or False. The following two classful IP \n" +
                            "addresses have the same network ID: 192.168.1.5 and 192.168.2.6",
                    "True or False. The following two classful IP \n" +
                            "addresses have the same network ID: 10.80.4.2 and 10.81.15.2001",
                    "Look at the following graphic, which letter or number would represent the default gateway for subnet B?\n" +
                            "(There is a picture here, probably isn't on the test.)",
                    "What is the subnet mask for the following IP address: 192.168.1.5 /26?",
                    "Which of the following IP addresses is in one of the reserved IP addresses ranges defined by RFC 1918?",
                    "How many hosts are supported in subnet with a network ID of 192.168.1.128 /26?",
                    "True or False. The following two classless IP addresses have the same network ID: 192.168.1.105 /26 and\n" +
                            "192.168.1.136 /26.",
                    "A computer is unable to communicate with other computers on the network. You use ipconfig and see the following\n" +
                            "information: IP address 169.254.5.7 \n" +
                            "Subnet mask: 255.255.0.0 \n" +
                            "Default gateway: blank\n" +
                            "DNS Server: blank",
                    //At this point this is Chapter 6 (8 extra questions)
                    "Which of the following addresses is a valid IPv6 address?",
                    "You need to manually assign an IPv6 address to a client computer for use within a private\n" +
                            "network. Which one of the following addresses should you use?",
                    "Which of the following features is built into IPv6 to provide extra security?",
                    "True or False. An IPv6 address with a prefix of id is a link-local address.",
                    "What IPv6 to IPv4 technology uses tunneling to encapsulate an IPv6 packet within an IPv4 packet?",
                    "You need to assign IPv6 addresses to hosts on a private network. You should use ____ addresses.",
                    "What IPv6 protocol is used to identify routers on the same network?",
                    "IPv4 addresses use public address on the Internet. IPv6 uses ____ addresses on the Internet.",
                    //At this point this is Chapter 7 (9 extra questions)
                    "What types of interference can cause problems for networks? (Choose all that apply)",
                    "A short-duration increase in AC power is a _______",
                    "True or False. The purpose of a UPS system is to provide long-term power when power fails.",
                    "True or False. STP provides protection against interference and cross talk.",
                    "The maximum distance of a CAT 6 twisted-pair cable between two connections is ______ meters.",
                    "What is the speed of a CAT 6 cable.",
                    "What does the T represent in a 100BaseT cable?",
                    "What tool can you use to capture traffic going across a network? (Choose all that apply)",
                    "What frequency does 802.11g use?",
                    //At this point this is Chapter 8 (10 extra questions)
                    "A ___ switch is expandable. You can add ports by adding components.",
                    "You are looking at a drawing a 100 Mbps switch and want to identify what device is connected to the\n" +
                            "first port. How will the port be labeled?",
                    "True or False. Layer 2 switches create seperate broadcast domains.",
                    "Your network includes computers connected via hubs. You want to reduce the number of collisions to \n" +
                            "the least number possible. What should you do?",
                    "True or False. A managed switch requires less administrative overhead than an unmanaged switch.",
                    "A layer 3 switch functions just like a ____",
                    "What does a switch maintain to track the location of computers?",
                    "A switch has 48 ports. How many VLANs can you create with it?",
                    "A 100 Mbps switch is configured to combine five ports using LACP with full-duplex. What is the \n" +
                            "effective throughput at the uplink?",
                    "You want to ensure that only known computers can connect to a switch. What should you\n" +
                            "implement? ",
                    //At this point this is Chapter 9 (8 extra questions)
                    "A router is configured in a network that includes multiple other routers. What routes does a\n" +
                            "router know by default?",
                    "You have added a second router to your network that inclues three subnets. What's the easiest way to ensure\n" +
                            "that both routers know the routes to all subnets?",
                    "True or False. A router determines the best path to another subnet based on the highest cost metric.",
                    "Where are routes known by a router?",
                    "Your network includes more than 50 hardware routers. What can you configure on these routers so that they\n" +
                            "will share routing information with each other?",
                    "True or False. Windows Server 2008 server supports RIPv2 and OSPF routing protocols.",
                    "A network includes a router that is not RFC 1542 compliant. Computers on one subnet use DHCP.\n" +
                            "What should you add to ensure computers on other subnets connected to the router can use DHCP?",
                    "True or False. You are adding a Windows Media Services server to your network that is using a Windows Server\n" +
                            "2008 server as router. You want to ensure that IP multicast traffic passes through the router. What would you add?",
                    //At this point this is Chapter 11 (7 extra questions)
                    "Which network security zone represents the highest risk?",
                    "What service translates private IP addresses to public IP addresses and translates public IP addresses\n" +
                            "and translates public IP address back to private?",
                    "An organization wants to restrict which web pages employees can access on the Internet using company\n" +
                            "computers. What should be implemented?",
                    "True or False. A DMZ provides a layer of security for Internet-facing servers.",
                    "How many firewalls are used to create a perimeter network? (Choose all that apply)",
                    "What allows computer to locate each other in a Microsoft network?",
                    "You want to provide access to some internal to a business partner via the Internet. No one else\n" +
                            "should have access. What should you create?",
                    //At this point this is Chapter 12 (10 extra questions)
                    "Which of the following statements about the service set identifier (SSID) are true? (Choose all that apply.)",
                    "True or False. 802.11 networks use CSMA/CD.",
                    "What frequency does an 802.11a network use?",
                    "Which of the following frequency ranges does 802.11b use?",
                    "What frequency does 802.11n network use? (Choose all that apply.)",
                    "What is the maximum speed of an IEE 802.11b network?",
                    "True or False. IEEE 802.11n networks can operate at speeds as high as 300 Mbps.",
                    "Of the following security methods, which one is the most secure?",
                    "True or False. A WAP and a wireless router are the same thing.",
                    "Your company is planning to lease a second building, which is about 2 miles away. You're asked\n" +
                            "how the networks between the two buildings can be connected. What would you suggest?"
                    //This is the end of the chapter questions. Add extra questions if needed.
            };

            //These are the multiple choice decisions. If blank, is just a placeholder so that it
            //stays in line with the array numbers i.e. 0-9, etc.
            Chapter1Choice = new String[] { "A.) Router B.) Switch \n C.) Firewall D.) VPN",
                    "",
                    "A.) LAN B.) WAN \n C.) VLAN D.) VPN",
                    "",
                    "A.) Change the network to a workgroup B.) Change the network to domain \n C.) Create a WAN" +
                            "D.) Create a VPN",
                    "",
                    "",
                    "A.) Domain Controller B.) LAN \n C.) WAP D.) VPN",
                    "A.) Dial-Up B.) WAP \n C.) VPN D.) Domain Controller",
                    "",
                    //At this point this is Chapter 2 (10 extra questions)
                    "A.) Unicast B.) Multicast \n C.) Broadcast D.) Allcast",
                    "",
                    "A.) Nothing. They are the same. B.) Switches do not pass broadcasts, but routers do. C.) A switch devices together, and a router \n" +
                            "connects subnets together. D.) A switch connects subnets together, and a router connects devices together.",
                    "",
                    //Fill this in with some examples
                    "",
                    //Fill this in with some examples
                    "",
                    "",
                    "A.) IEEE 802.3 B.) RFC 791 \n C.) Extranet wiring practices D.) T568B",
                    //Fill this in with some examples
                    "",
                    //Fill this in with some examples
                    "",
                    //At this point this is Chapter 3 (10 extra questions)
                    "",
                    "",
                    "",
                    "A.) Packet B.) Segment \nC.) Frame D.) Protocol data unit (PDU)",
                    "A.) Server 1 B.) 192.168.1.5 \n C.) A4-BA-DB-FA-60-AD D.) G4-BA-10B-FA-60-AT",
                    "",
                    "",
                    "",
                    "A.) Layer 1 B.) Layer 2 \nC.) Layer 3 D.) Layer 4 \nE.) None of the Above",
                    "A.) Layer1 B.) Layer 2 \nC.) Layer 3 D.) Layer 4 \nE.) None of the above",
                    //At this point this is Chapter 4 (10 extra questions)
                    "A.) UDP B.) TCP \nC.) ARP D.) DHCP",
                    "",
                    "A.) Streaming audio B.) Streaming video \nC.) HTTP traffic D.) Voice over IP",
                    "A.) DNS B.) TCP \nC.) ARP D.) ICMP",
                    "",
                    "",
                    "",
                    "A.) 389 B.) 636 \nC.) 1701 D.) 3389",
                    "A.) 25 B.) 389 \nC.) 1723 D.) 3389",
                    "A.) 25 B.) 80 \nC.) 88 D.) 443",
                    //At this point this is Chapter 5 (10 extra questions)
                    "A.) 192.168.1.256 B.) 10.1.25.2 \n" +
                            "C.) 2001:0000:4137:9e76:3c2b:05ad:3f57:fe98\n" +
                            "D.) 2001:0000:4137:9g76:3c2b:05zd:3x57:gh98",
                    "A.) Class A B.) Class B C.) Class C D.) Class D",
                    "",
                    "",
                    "",
                    "A.) 192.168.1.5 B.) 255.255.255.0 \nC.) 255.255.255.192 D.) 255.255.255.240",
                    "A.) 10.80.256.1 B.) 172.17.34.14 \nC.) 192.169.4.5 D.) 244.17.2.5",
                    "A.) 30 B.) 32 \nC.) 62 D.) 64",
                    "",
                    "A.) A DHCP server can't be reached B.) The default gateway needs to be manually configured \n" +
                            "C.) The DNS server IP address needs to be manually configured\n" +
                            "D.) None of the above.",
                    //At this point this is Chapter 6 (8 extra questions)
                    "A.) 192.168.1.256 B.) 10.1.25.2 \n" +
                            "C.) 2001:0000:4137:9e76:3c2b:05ad:3f57:fe98\n" +
                            "D.) 2001:0000:4137:9g76:3c2b:05zd:3x57:gh98",
                    "A.) 0000::a123:4567:89ab:cdef\n" +
                            "B.) 2001:0001::fcde:ba98:7654\n" +
                            "C.) 2001:0000:fcde:ba98:7654\n" +
                            "D.) fe80:: a123:4567:89ab:cdef\n" +
                            "E.) fd00:: a123:4567:89ab:cdef",
                    "A.) Teredo tunnelling B.) Global addresses \n" +
                            "C.) Unique local addresses D.) IPSec",
                    "",
                    "",
                    "",
                    "A.) Network Discovery B.) Teredo \n" +
                            "C.) IGMP D.) Anycast",
                    "",
                    //At this point this is Chapter 7 (9 extra questions)
                    "A.) EMI B.) RFI \nC.) STI D.) PCI",
                    "A.) Power Spike B.) Power Surge \nC.) Power Sag D.) Surge Protector",
                    "",
                    "",
                    "",
                    "A.) 10 Mbps B.) 100 Mbps \nC.) 1000 Mbps D.) 10000 Mbps",
                    "",
                    "A.) Microsoft's Network Monitor B.) A protocol analyser \nC.) A network sniffer D.) A wire crimper",
                    "A.) 2.4 GHz B.) 2.4 and 5 Ghz \nC.) 5 GHz D.) 9 Ghz",
                    //At this point this is Chapter 8 (10 extra questions)
                    "",
                    "A.) E0 B.) F0 \n C.) F1 D.) Gi1",
                    "",
                    "A.) You should replace the hubs with bridges. B.) You should replace the hubs with managed hubs \n" +
                            "C.) You should replace the hubs with switches D.) You should replace the hubs with firewalls.",
                    "",
                    "",
                    "A.) A MAC address table B.) A routing table \n" +
                            "C.) A layer 3 table D.) A managed table",
                    "A.) 2 B.) 12 \n C.)24 D.) 48",
                    "A.)100 Mbps B.) 500 Mbps \n C.) 600 Mbps D.) 1000 Mbps",
                    "",
                    //At this point this is Chapter 9 (8 extra questions)
                    "A.) Directly connected routes B.) Static routes \n C.) Dynamic routes D.) Routes added to the routing table",
                    "A.) Add OSPF to each router. B.) Add RIPv2 to each router. \nC.) Add dynamic routes. D.) Add static routes.",
                    "",
                    "",
                    "A.) RIPv2 B.) OSPF \nC.) Routing protocols D.) ARP",
                    "",
                    "A.) Another DHCP server B.) DHCP relay agent \nC.) RIPv2 D.) OSPF",
                    "A.) OSPF B.) RIPv2 \n C.) IGMP Router and Proxy service D.) DHCP relay agent",
                    //At this point this is Chapter 11 (7 extra questions)
                    "A.) Internet B.) Intranet \nC.) Perimeter Network D.) Extranet",
                    "",
                    "A.) NAT B.) Firewall \nC.) Proxy server D.) Reverse proxy server",
                    "",
                    "A.) One B.) Two \nC.) Three D.) Four",
                    "A.) Firewall B.) Public network location \nC.) Network discovery D.) Proxy server",
                    "",
                    //At this point this is Chapter 12 (10 extra questions)
                    "A.) The SSID is an alphanumeric value that identifies the vendor's device type\n" +
                            "B.) The SSID is an alphanumeric information field with a maximum value of 32 bits.\n" +
                            "C.) The SSID is a logical network name for a wireless network.\n" +
                            "D.) The SSID identifies the security encryption method.",
                    "",
                    "A.) 11 Mbps B.) 54 Mbps \nC.) 2.4 MHz D.) 5 GHz",
                    "A.) 2.4 GHz, B.) 4.1 GHz \nC.) 2.4 MHz, D.) 5 GHz",
                    "A.) 54 Mbps B.) 300 Mbps \nC.) 2.4 MHz D.) 5 GHz",
                    "A.) 2 Mbps B.) 11 Mbps \nC.) 54 Mbps D.) 300 Mbps",
                    "",
                    "A.) WEP Personal Mode B.) WEP Enterprise Mode \nC.) WPA2 Personal Mode D.) WPA2 Enterprise Mode",
                    "",
                    "A.) B.) C.) D.)"
                    //This is the end of the chapter questions. Add extra questions if needed.
            };

            //These are the literal answers from the question that is asked.
            Chapter1Answers = new String[] { "C",
                    "True",
                    "A",
                    "Bits",
                    "B",
                    "A group of computers connected together in a network",
                    "Typically two or more LANs connected together over a large geographical\n" +
                            "distance.",
                    "D",
                    "A, C",
                    "False",
                    //At this point this is Chapter 2 (10 extra questions)
                    "C",
                    "False",
                    "C",
                    "True",
                    "Rules",
                    "A software component that provides protection for a single system Network-based" +
                            " firewalls include both hardware and software.",
                    "False",
                    "D",
                    "A perimeter network",
                    "Extranet",
                    //At this point this is Chapter 3 (10 extra questions)
                    "Seven",
                    "All People Seem To Need Data Processing / Please Do Not Throw Sausage Pizza Away",
                    "False",
                    "B",
                    "C",
                    "Network",
                    "TCP and UDP",
                    "True",
                    "C",
                    "E",
                    //At this point this is Chapter 4 (10 extra questions)
                    "B",
                    "True",
                    "A, B, D",
                    "C",
                    "SMTP, POP3, and IMAP4",
                    "IPSec",
                    "IGMP",
                    "D",
                    "B",
                    "C",
                    //At this point this is Chapter 5 (10 extra questions)
                    "B",
                    "C",
                    "False",
                    "True",
                    "Point B",
                    "C",
                    "B",
                    "C",
                    "False",
                    "A",
                    //At this point this is Chapter 6 (8 extra questions)
                    "C",
                    "E",
                    "D",
                    "False",
                    "Teredo",
                    "Unique Local Addresses",
                    "A",
                    "Global Unicast",
                    //At this point this is Chapter 7 (9 extra questions)
                    "A, B",
                    "A",
                    "False",
                    "True",
                    "100",
                    "C",
                    "Twisted Pair Using Four Twisted Pairs",
                    "A, B, C",
                    "A",
                    //At this point this is Chapter 8 (10 extra questions)
                    "Modular Switch",
                    "B",
                    "False",
                    "C",
                    "False",
                    "Router",
                    "A",
                    "C",
                    "D",
                    "Port Security",
                    //At this point this is Chapter 9 (8 extra questions)
                    "A",
                    "D",
                    "False",
                    "Routing Table",
                    "A, B, C",
                    "False",
                    "B",
                    "C",
                    //At this point this is Chapter 11 (7 extra questions)
                    "A",
                    "Network Address Translation (NAT)",
                    "C",
                    "True",
                    "A, B",
                    "C",
                    "An Extranet",
                    //At this point this is Chapter 12 (10 extra questions)
                    "B, C",
                    "False",
                    "D",
                    "A",
                    "C, D",
                    "B",
                    "True",
                    "D",
                    "False",
                    "B"
                    //This is the end of the chapter questions. Add extra questions if needed.
            };

        //Sets up the inital question to prompt the person about the question.
        question.setText(Chapter1[randomQuestion]);
        //Sets up the multiple choice options, if viable.
        questionAnswers.setText(Chapter1Choice[randomQuestion]);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.Answer:
                testQuestions();
                theTest();
                break;
            case R.id.Skip:
                theTest();
                decideAnswer.setText("");
                break;
        }
    }

    public void theTest()
    {
        answer.setText("Submit");
        Random randQuestion = new Random();

        randomQuestion = randQuestion.nextInt(102);

            //These are the literal questions in the book.
            Chapter1 = new String[] { "What should be enabled on a computer that has direct connection to the\n" +
                    "Internet?",
                    "True or False. A WAP often provides access to the Internet",
                    "A group of computers are connected in a single location. What is this called?",
                    "A network is connected using high-speed components rated at 1 GBPS. What does the b represent in GBPS?",
                    "Users in the network have to remember an average of five usernames and passwords\n" +
                            "to access different computers. How can you reduce the number of passwords remembered\n" +
                            "by users?",
                    "Define a LAN.",
                    "Define a WAN.",
                    "An employee is able to connect to the employer's private network over the Internet. What is the employee using?",
                    "What are two types of remote access servers? (Choose two)",
                    "True or False. All RFCs are known standards.",
                    //At this point this is Chapter 2 (10 extra questions)
                    "What type of traffic always goes to all devices in a subnet?",
                    "True or False. A switch blocks broadcasts.",
                    "What is the difference between a switch and a router?",
                    "True or False. Bridges can connect dissimilar physical topologies.",
                    "A firewall uses _______ to filter both inbound and outbound traffic.",
                    "A network-based firewall is a hardware device that provides protection for a network. What is a host-based firewall?",
                    "True or False. A crossover cable is used to connect a computer to a switch.",
                    "Which of the following standards define how twisted-pair cables should be wired?",
                    "A company wants to host a web server for Internet users. The web server should be placed in ____.",
                    "What is used to provide access to a company's resources via the Internet to trusted partners?",
                    //At this point this is Chapter 3 (10 extra questions)
                    "The OSI Model has _______ layers.",
                    "Write down a mnemonic you use to remember the OSI Model.",
                    "True or False. TCP is a connectionless protocol.",
                    "What is a unit of data called at the Transport layer?",
                    "Which of the following could be a valid MAC address for a server named Server 1?",
                    "IPv4 operates on the _________ layer of the OSI Model.",
                    "List the protocols that operate on the Transport layer of the OSI Model.",
                    "True or False. Devices that operate on layer 7 of the OSI Model are more intelligent that devices that operate on layer 1.",
                    "Routers operate on which of the following layers of the OSI Model?",
                    "Proxy servers operate on which of the following layers of the OSI Model?",
                    //At this point this is Chapter 4 (10 extra questions)
                    "Which of the following protocols is considered connection-orientated?",
                    "True or False. UDP traffic accepts the loss of some data.",
                    "What type of traffic commonly uses UDP? (Choose all that apply)",
                    "What is used to resolve an IP address to a MAC address?",
                    "List three commonly used protocols for email.",
                    "L2TP is one of many tunnelling protocols used for VPNs. What is used to encrypt L2TP traffic?",
                    "The _______ protocol is used to manage multicast transmissions.",
                    "What port is used by RDS",
                    "What port is used by LDAP?",
                    "What port is used by Kerberos?",
                    //At this point this is Chapter 5 (10 extra questions)
                    "Which of the following addresses is a valid IPv4 address?",
                    "What class is the following IP address: 192.168.1.5?",
                    "True or False. The following two classful IP \n" +
                            "addresses have the same network ID: 192.168.1.5 and 192.168.2.6",
                    "True or False. The following two classful IP \n" +
                            "addresses have the same network ID: 10.80.4.2 and 10.81.15.2001",
                    "Look at the following graphic, which letter or number would represent the default gateway for subnet B?\n" +
                            "(There is a picture here, probably isn't on the test.)",
                    "What is the subnet mask for the following IP address: 192.168.1.5 /26?",
                    "Which of the following IP addresses is in one of the reserved IP addresses ranges defined by RFC 1918?",
                    "How many hosts are supported in subnet with a network ID of 192.168.1.128 /26?",
                    "True or False. The following two classless IP addresses have the same network ID: 192.168.1.105 /26 and\n" +
                            "192.168.1.136 /26.",
                    "A computer is unable to communicate with other computers on the network. You use ipconfig and see the following\n" +
                            "information: IP address 169.254.5.7 \n" +
                            "Subnet mask: 255.255.0.0 \n" +
                            "Default gateway: blank\n" +
                            "DNS Server: blank",
                    //At this point this is Chapter 6 (8 extra questions)
                    "Which of the following addresses is a valid IPv6 address?",
                    "You need to manually assign an IPv6 address to a client computer for use within a private\n" +
                            "network. Which one of the following addresses should you use?",
                    "Which of the following features is built into IPv6 to provide extra security?",
                    "True or False. An IPv6 address with a prefix of id is a link-local address.",
                    "What IPv6 to IPv4 technology uses tunneling to encapsulate an IPv6 packet within an IPv4 packet?",
                    "You need to assign IPv6 addresses to hosts on a private network. You should use ____ addresses.",
                    "What IPv6 protocol is used to identify routers on the same network?",
                    "IPv4 addresses use public address on the Internet. IPv6 uses ____ addresses on the Internet.",
                    //At this point this is Chapter 7 (9 extra questions)
                    "What types of interference can cause problems for networks? (Choose all that apply)",
                    "A short-duration increase in AC power is a _______",
                    "True or False. The purpose of a UPS system is to provide long-term power when power fails.",
                    "True or False. STP provides protection against interference and cross talk.",
                    "The maximum distance of a CAT 6 twisted-pair cable between two connections is ______ meters.",
                    "What is the speed of a CAT 6 cable.",
                    "What does the T represent in a 100BaseT cable?",
                    "What tool can you use to capture traffic going across a network? (Choose all that apply)",
                    "What frequency does 802.11g use?",
                    //At this point this is Chapter 8 (10 extra questions)77
                    "A ___ switch is expandable. You can add ports by adding components.",
                    "You are looking at a drawing a 100 Mbps switch and want to identify what device is connected to the\n" +
                            "first port. How will the port be labeled?",
                    "True or False. Layer 2 switches create seperate broadcast domains.",
                    "Your network includes computers connected via hubs. You want to reduce the number of collisions to \n" +
                            "the least number possible. What should you do?",
                    "True or False. A managed switch requires less administrative overhead than an unmanaged switch.",
                    "A layer 3 switch functions just like a ____",
                    "What does a switch maintain to track the location of computers?",
                    "A switch has 48 ports. How many VLANs can you create with it?",
                    "A 100 Mbps switch is configured to combine five ports using LACP with full-duplex. What is the \n" +
                            "effective throughput at the uplink?",
                    "You want to ensure that only known computers can connect to a switch. What should you\n" +
                            "implement? ",
                    //At this point this is Chapter 9 (8 extra questions)85
                    "A router is configured in a network that includes multiple other routers. What routes does a\n" +
                            "router know by default?",
                    "You have added a second router to your network that inclues three subnets. What's the easiest way to ensure\n" +
                            "that both routers know the routes to all subnets?",
                    "True or False. A router determines the best path to another subnet based on the highest cost metric.",
                    "Where are routes known by a router?",
                    "Your network includes more than 50 hardware routers. What can you configure on these routers so that they\n" +
                            "will share routing information with each other?",
                    "True or False. Windows Server 2008 server supports RIPv2 and OSPF routing protocols.",
                    "A network includes a router that is not RFC 1542 compliant. Computers on one subnet use DHCP.\n" +
                            "What should you add to ensure computers on other subnets connected to the router can use DHCP?",
                    "True or False. You are adding a Windows Media Services server to your network that is using a Windows Server\n" +
                            "2008 server as router. You want to ensure that IP multicast traffic passes through the router. What would you add?",
                    //At this point this is Chapter 11 (7 extra questions)92
                    "Which network security zone represents the highest risk?",
                    "What service translates private IP addresses to public IP addresses and translates public IP addresses\n" +
                            "and translates public IP address back to private?",
                    "An organization wants to restrict which web pages employees can access on the Internet using company\n" +
                            "computers. What should be implemented?",
                    "True or False. A DMZ provides a layer of security for Internet-facing servers.",
                    "How many firewalls are used to create a perimeter network? (Choose all that apply)",
                    "What allows computer to locate each other in a Microsoft network?",
                    "You want to provide access to some internal to a business partner via the Internet. No one else\n" +
                            "should have access. What should you create?",
                    //At this point this is Chapter 12 (10 extra questions)102
                    "Which of the following statements about the service set identifier (SSID) are true? (Choose all that apply.)",
                    "True or False. 802.11 networks use CSMA/CD.",
                    "What frequency does an 802.11a network use?",
                    "Which of the following frequency ranges does 802.11b use?",
                    "What frequency does 802.11n network use? (Choose all that apply.)",
                    "What is the maximum speed of an IEE 802.11b network?",
                    "True or False. IEEE 802.11n networks can operate at speeds as high as 300 Mbps.",
                    "Of the following security methods, which one is the most secure?",
                    "True or False. A WAP and a wireless router are the same thing.",
                    "Your company is planning to lease a second building, which is about 2 miles away. You're asked\n" +
                            "how the networks between the two buildings can be connected. What would you suggest?"
                    //This is the end of the chapter questions. Add extra questions if needed.
            };

            //These are the multiple choice decisions. If blank, is just a placeholder so that it
            //stays in line with the array numbers i.e. 0-9, etc.
            Chapter1Choice = new String[] { "A.) Router B.) Switch \n C.) Firewall D.) VPN",
                    "",
                    "A.) LAN B.) WAN \n C.) VLAN D.) VPN",
                    "",
                    "A.) Change the network to a workgroup B.) Change the network to domain \n C.) Create a WAN" +
                            "D.) Create a VPN",
                    "",
                    "",
                    "A.) Domain Controller B.) LAN \n C.) WAP D.) VPN",
                    "A.) Dial-Up B.) WAP \n C.) VPN D.) Domain Controller",
                    "",
                    //At this point this is Chapter 2 (10 extra questions)
                    "A.) Unicast B.) Multicast \n C.) Broadcast D.) Allcast",
                    "",
                    "A.) Nothing. They are the same. B.) Switches do not pass broadcasts, but routers do. C.) A switch devices together, and a router \n" +
                            "connects subnets together. D.) A switch connects subnets together, and a router connects devices together.",
                    "",
                    //Fill this in with some examples
                    "",
                    //Fill this in with some examples
                    "",
                    "",
                    "A.) IEEE 802.3 B.) RFC 791 \n C.) Extranet wiring practices D.) T568B",
                    //Fill this in with some examples
                    "",
                    //Fill this in with some examples
                    "",
                    //At this point this is Chapter 3 (10 extra questions)
                    "",
                    "",
                    "",
                    "A.) Packet B.) Segment \nC.) Frame D.) Protocol data unit (PDU)",
                    "A.) Server 1 B.) 192.168.1.5 \n C.) A4-BA-DB-FA-60-AD D.) G4-BA-10B-FA-60-AT",
                    "",
                    "",
                    "",
                    "A.) Layer 1 B.) Layer 2 \nC.) Layer 3 D.) Layer 4 \nE.) None of the Above",
                    "A.) Layer1 B.) Layer 2 \nC.) Layer 3 D.) Layer 4 \nE.) None of the above",
                    //At this point this is Chapter 4 (10 extra questions)
                    "A.) UDP B.) TCP \nC.) ARP D.) DHCP",
                    "",
                    "A.) Streaming audio B.) Streaming video \nC.) HTTP traffic D.) Voice over IP",
                    "A.) DNS B.) TCP \nC.) ARP D.) ICMP",
                    "",
                    "",
                    "",
                    "A.) 389 B.) 636 \nC.) 1701 D.) 3389",
                    "A.) 25 B.) 389 \nC.) 1723 D.) 3389",
                    "A.) 25 B.) 80 \nC.) 88 D.) 443",
                    //At this point this is Chapter 5 (10 extra questions)
                    "A.) 192.168.1.256 B.) 10.1.25.2 \n" +
                            "C.) 2001:0000:4137:9e76:3c2b:05ad:3f57:fe98\n" +
                            "D.) 2001:0000:4137:9g76:3c2b:05zd:3x57:gh98",
                    "A.) Class A B.) Class B C.) Class C D.) Class D",
                    "",
                    "",
                    "",
                    "A.) 192.168.1.5 B.) 255.255.255.0 \nC.) 255.255.255.192 D.) 255.255.255.240",
                    "A.) 10.80.256.1 B.) 172.17.34.14 \nC.) 192.169.4.5 D.) 244.17.2.5",
                    "A.) 30 B.) 32 \nC.) 62 D.) 64",
                    "",
                    "A.) A DHCP server can't be reached B.) The default gateway needs to be manually configured \n" +
                            "C.) The DNS server IP address needs to be manually configured\n" +
                            "D.) None of the above.",
                    //At this point this is Chapter 6 (8 extra questions)
                    "A.) 192.168.1.256 B.) 10.1.25.2 \n" +
                            "C.) 2001:0000:4137:9e76:3c2b:05ad:3f57:fe98\n" +
                            "D.) 2001:0000:4137:9g76:3c2b:05zd:3x57:gh98",
                    "A.) 0000::a123:4567:89ab:cdef\n" +
                            "B.) 2001:0001::fcde:ba98:7654\n" +
                            "C.) 2001:0000:fcde:ba98:7654\n" +
                            "D.) fe80:: a123:4567:89ab:cdef\n" +
                            "E.) fd00:: a123:4567:89ab:cdef",
                    "A.) Teredo tunnelling B.) Global addresses \n" +
                            "C.) Unique local addresses D.) IPSec",
                    "",
                    "",
                    "",
                    "A.) Network Discovery B.) Teredo \n" +
                            "C.) IGMP D.) Anycast",
                    "",
                    //At this point this is Chapter 7 (9 extra questions)
                    "A.) EMI B.) RFI \nC.) STI D.) PCI",
                    "A.) Power Spike B.) Power Surge \nC.) Power Sag D.) Surge Protector",
                    "",
                    "",
                    "",
                    "A.) 10 Mbps B.) 100 Mbps \nC.) 1000 Mbps D.) 10000 Mbps",
                    "",
                    "A.) Microsoft's Network Monitor B.) A protocol analyser \nC.) A network sniffer D.) A wire crimper",
                    "A.) 2.4 GHz B.) 2.4 and 5 Ghz \nC.) 5 GHz D.) 9 Ghz",
                    //At this point this is Chapter 8 (10 extra questions)
                    "",
                    "A.) E0 B.) F0 \n C.) F1 D.) Gi1",
                    "",
                    "A.) You should replace the hubs with bridges. B.) You should replace the hubs with managed hubs \n" +
                            "C.) You should replace the hubs with switches D.) You should replace the hubs with firewalls.",
                    "",
                    "",
                    "A.) A MAC address table B.) A routing table \n" +
                            "C.) A layer 3 table D.) A managed table",
                    "A.) 2 B.) 12 \n C.)24 D.) 48",
                    "A.)100 Mbps B.) 500 Mbps \n C.) 600 Mbps D.) 1000 Mbps",
                    "",
                    //At this point this is Chapter 9 (8 extra questions)
                    "A.) Directly connected routes B.) Static routes \n C.) Dynamic routes D.) Routes added to the routing table",
                    "A.) Add OSPF to each router. B.) Add RIPv2 to each router. \nC.) Add dynamic routes. D.) Add static routes.",
                    "",
                    "",
                    "A.) RIPv2 B.) OSPF \nC.) Routing protocols D.) ARP",
                    "",
                    "A.) Another DHCP server B.) DHCP relay agent \nC.) RIPv2 D.) OSPF",
                    "A.) OSPF B.) RIPv2 \n C.) IGMP Router and Proxy service D.) DHCP relay agent",
                    //At this point this is Chapter 11 (7 extra questions)
                    "A.) Internet B.) Intranet \nC.) Perimeter Network D.) Extranet",
                    "",
                    "A.) NAT B.) Firewall \nC.) Proxy server D.) Reverse proxy server",
                    "",
                    "A.) One B.) Two \nC.) Three D.) Four",
                    "A.) Firewall B.) Public network location \nC.) Network discovery D.) Proxy server",
                    "",
                    //At this point this is Chapter 12 (10 extra questions)
                    "A.) The SSID is an alphanumeric value that identifies the vendor's device type\n" +
                            "B.) The SSID is an alphanumeric information field with a maximum value of 32 bits.\n" +
                            "C.) The SSID is a logical network name for a wireless network.\n" +
                            "D.) The SSID identifies the security encryption method.",
                    "",
                    "A.) 11 Mbps B.) 54 Mbps \nC.) 2.4 MHz D.) 5 GHz",
                    "A.) 2.4 GHz, B.) 4.1 GHz \nC.) 2.4 MHz, D.) 5 GHz",
                    "A.) 54 Mbps B.) 300 Mbps \nC.) 2.4 MHz D.) 5 GHz",
                    "A.) 2 Mbps B.) 11 Mbps \nC.) 54 Mbps D.) 300 Mbps",
                    "",
                    "A.) WEP Personal Mode B.) WEP Enterprise Mode \nC.) WPA2 Personal Mode D.) WPA2 Enterprise Mode"
                    //This is the end of the chapter questions. Add extra questions if needed.
            };

            //These are the literal answers from the question that is asked.
            Chapter1Answers = new String[] { "C",
                    "True",
                    "A",
                    "Bits",
                    "B",
                    "A group of computers connected together in a network",
                    "Typically two or more LANs connected together over a large geographical\n" +
                            "distance.",
                    "D",
                    "A, C",
                    "False",
                    //At this point this is Chapter 2 (10 extra questions)
                    "C",
                    "False",
                    "C",
                    "True",
                    "Rules",
                    "A software component that provides protection for a single system Network-based" +
                            " firewalls include both hardware and software.",
                    "False",
                    "D",
                    "A perimeter network",
                    "Extranet",
                    //At this point this is Chapter 3 (10 extra questions)
                    "Seven",
                    "All People Seem To Need Data Processing / Please Do Not Throw Sausage Pizza Away",
                    "False",
                    "B",
                    "C",
                    "Network",
                    "TCP and UDP",
                    "True",
                    "C",
                    "E",
                    //At this point this is Chapter 4 (10 extra questions)
                    "B",
                    "True",
                    "A, B, D",
                    "C",
                    "SMTP, POP3, and IMAP4",
                    "IPSec",
                    "IGMP",
                    "D",
                    "B",
                    "C",
                    //At this point this is Chapter 5 (10 extra questions)
                    "B",
                    "C",
                    "False",
                    "True",
                    "Point B",
                    "C",
                    "B",
                    "C",
                    "False",
                    "A",
                    //At this point this is Chapter 6 (8 extra questions)
                    "C",
                    "E",
                    "D",
                    "False",
                    "Teredo",
                    "Unique Local Addresses",
                    "A",
                    "Global Unicast",
                    //At this point this is Chapter 7 (9 extra questions)
                    "A, B",
                    "A",
                    "False",
                    "True",
                    "100",
                    "C",
                    "Twisted Pair Using Four Twisted Pairs",
                    "A, B, C",
                    "A",
                    //At this point this is Chapter 8 (10 extra questions)
                    "Modular Switch",
                    "B",
                    "False",
                    "C",
                    "False",
                    "Router",
                    "A",
                    "C",
                    "D",
                    "Port Security",
                    //At this point this is Chapter 9 (8 extra questions)
                    "A",
                    "D",
                    "False",
                    "Routing Table",
                    "A, B, C",
                    "False",
                    "B",
                    "C",
                    //At this point this is Chapter 11 (7 extra questions)
                    "A",
                    "Network Address Translation (NAT)",
                    "C",
                    "True",
                    "A, B",
                    "C",
                    "An Extranet",
                    //At this point this is Chapter 12 (10 extra questions)
                    "B, C",
                    "False",
                    "D",
                    "A",
                    "C, D",
                    "B",
                    "True",
                    "D",
                    "False",
                    "B"
                    //This is the end of the chapter questions. Add extra questions if needed.
            };

        //Sets up the inital question to prompt the person about the question.
        question.setText(Chapter1[randomQuestion]);
        //Sets up the multiple choice options, if viable.
        questionAnswers.setText(Chapter1Choice[randomQuestion]);
    }

    public void testQuestions()
    {
        //Decides whether the user got the answer correct.
        if (edittext.getText().toString().equalsIgnoreCase(Chapter1Answers[randomQuestion]))
        {
            rightAnswer();
        }
        else
        {
            wrongAnswer();
        }
    }

    public void rightAnswer()
    {
            if (randomQuestion <= 10)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Correct\n\n"
                            + "Chapter 1 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 10 && randomQuestion <= 20)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Correct\n\n"
                            + "Chapter 2 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 20 && randomQuestion <= 30)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Correct\n\n"
                            + "Chapter 3 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 30 && randomQuestion <= 40)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Correct\n\n"
                            + "Chapter 4 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 40 && randomQuestion <= 50)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Correct\n\n"
                            + "Chapter 5 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 50 && randomQuestion <= 59)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Correct\n\n"
                            + "Chapter 6 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 59 && randomQuestion <= 67)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Correct\n\n"
                            + "Chapter 7 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 67 && randomQuestion <= 77)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Correct\n\n"
                            + "Chapter 8 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 77 && randomQuestion <= 85)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Correct\n\n"
                            + "Chapter 9 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 85 && randomQuestion <= 92)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Correct\n\n"
                            + "Chapter 11 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 92 && randomQuestion <= 102)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Correct\n\n"
                            + "Chapter 12 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else
            {
                    decideAnswer.setText(edittext.getText().toString()+" Correct");
                    edittext.setText("");
            }

    }

    public void wrongAnswer()
    {
            if (randomQuestion <= 10)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Incorrect\n\n"+
                            "\n It was "+Chapter1Answers[randomQuestion] +"\n"
                            + "Chapter 1 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 10 && randomQuestion <= 20)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Incorrect\n\n"+
                            "\n It was "+Chapter1Answers[randomQuestion] +"\n"
                            + "Chapter 2 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 20 && randomQuestion <= 30)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Incorrect\n\n"+
                            "\n It was "+Chapter1Answers[randomQuestion] +"\n"
                            + "Chapter 3 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 30 && randomQuestion <= 40)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Incorrect\n\n"+
                            "\n It was "+Chapter1Answers[randomQuestion] +"\n"
                            + "Chapter 4 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 40 && randomQuestion <= 50)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Incorrect\n\n"+
                            "\n It was "+Chapter1Answers[randomQuestion] +"\n"
                            + "Chapter 5 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 50 && randomQuestion <= 59)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Incorrect\n\n"+
                            "\n It was "+Chapter1Answers[randomQuestion] +"\n"
                            + "Chapter 6 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 59 && randomQuestion <= 67)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Incorrect\n\n"+
                            "\n It was "+Chapter1Answers[randomQuestion] +"\n"
                            + "Chapter 7 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 67 && randomQuestion <= 77)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Incorrect\n\n"+
                            "\n It was "+Chapter1Answers[randomQuestion] +"\n"
                            + "Chapter 8 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 77 && randomQuestion <= 85)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Incorrect\n\n"+
                            "\n It was "+Chapter1Answers[randomQuestion] +"\n"
                            + "Chapter 9 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 85 && randomQuestion <= 92)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Incorrect\n\n" +
                            "\n It was "+Chapter1Answers[randomQuestion] +"\n"
                            + "Chapter 11 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else if (randomQuestion > 92 && randomQuestion <= 102)
            {
                    decideAnswer.setText(edittext.getText().toString()+" Incorrect\n\n"
                            + "Chapter 12 Question.\n"+Chapter1[randomQuestion]);
                    edittext.setText("");
            }
            else
            {
                    decideAnswer.setText(edittext.getText().toString()+" was Incorrect." +
                            "\n It was "+Chapter1Answers[randomQuestion]);
                    edittext.setText("");
            }
    }

    public void onBackPressed()
    {
        this.finish();
    }
}
