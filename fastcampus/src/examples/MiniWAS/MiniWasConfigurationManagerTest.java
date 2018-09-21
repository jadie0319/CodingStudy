package examples.MiniWAS;

public class MiniWasConfigurationManagerTest {
    public static void main(String[] args) {
        MiniWasConfigurationManager wcm =
                MiniWasConfigurationManager.getInstance();

        MiniWasConfigurationManager wcm2 =
                MiniWasConfigurationManager.getInstance();

        if(wcm  == wcm2) {
            System.out.println("같은 참조 입니다.");
        }

        MiniWasConfiguration miniWasConfiguration =  new MiniWasConfiguration();
        miniWasConfiguration.setStaticDir("/tmp/www");
        miniWasConfiguration.setClassPath(".");

        wcm.saveMiniWasConfiguration(miniWasConfiguration, "/tmp/m.json");

        MiniWasConfiguration mwc = wcm.getMiniWasConfiguration("/tmp/m.json");
        System.out.println(mwc.getStaticDir());
        System.out.println(mwc.getClassPath());
    }

}
