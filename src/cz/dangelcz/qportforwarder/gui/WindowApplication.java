package cz.dangelcz.qportforwarder.gui;

import cz.dangelcz.qportforwarder.launch.AppLauncher;
import cz.dangelcz.qportforwarder.libs.GeneralHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class WindowApplication extends Application
{
	private static Logger logger = LogManager.getLogger(WindowApplication.class);


	@Override
	public void start(Stage stage) throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(WindowApplication.class.getResource("/forwarding_pane.fxml"));

		try
		{
			Scene scene = new Scene(fxmlLoader.load(), 800, 480);

			String version = GeneralHelper.getPomXmlVersion();
			stage.setTitle("QPortForwarder " + version);
			stage.setScene(scene);
			stage.show();
		}
		catch (Exception e)
		{
			// log error
			logger.error(e);
			// rethrow error into framework
			throw e;
		}
	}
}
