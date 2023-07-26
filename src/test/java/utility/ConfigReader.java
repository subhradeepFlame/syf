package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	File file;
	FileInputStream fis;
	static Properties pro;

	public ConfigReader() {

		try {
			file = new File(System.getProperty("user.dir") + "/src/test/resources/config.properties");
			fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getEnv() {
		String env = null;
		env = System.getProperty("env");
		if (env == null || env.isEmpty()) {
			env = pro.getProperty("env");
		}
		return env;
	}

	private String getProtocol() {
		String protocol = pro.getProperty("protocol");
		return protocol;
	}

	public String getUrl() {
		String url = getProtocol() + getEnv() + pro.getProperty("Url");
		return url;
	}


	public String getBrowser() {
		return (pro.getProperty("browser"));
	}

	public String getconfigdData(String st) {
		return (pro.getProperty(st));
	}

	public int getconfigdDataInt(String st) {
		return Integer.parseInt(pro.getProperty(st));
	}

	public int getExplicitTime() {
		return getconfigdDataInt("explicitWaitTime");
	}
	
	public String getSuperAdminId() {
		return getconfigdData("SuperAdminId");
	}
	public String getLoginPassword() {
		return getconfigdData("LoginPassword");
	}

	



	public void setKeyValue(String key, String value) {
		Properties props = new Properties();
		File f = file;
		try {
			final FileInputStream configStream = new FileInputStream(f);
			props.load(configStream);
			configStream.close();
			props.setProperty(key, value);
			final FileOutputStream output = new FileOutputStream(f);
			props.store(output, "");
			output.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}	public void setKeyValue(File file,String key, String value) {
		Properties props = new Properties();
		File f = file;
		try {
			final FileInputStream configStream = new FileInputStream(f);
			props.load(configStream);
			configStream.close();
			props.setProperty(key, value);
			final FileOutputStream output = new FileOutputStream(f);
			props.store(output, "");
			output.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String getHeadlessStatus(String st) {
		return getconfigdData(st);
	}
}
