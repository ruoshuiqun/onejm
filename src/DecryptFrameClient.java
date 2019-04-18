import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

public class DecryptFrameClient extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	static String path = null;
	public static void main(String[] args) {
		try
	    {
	        //设置本属性将改变窗口边框样式定义
	        //BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
	        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    }
	   // ..................... 你的程序代码 .........................
	   // ..................... 你的程序代码 .........................	
		        // 画出窗口
		        final DecryptFrameClient frame = new DecryptFrameClient();
		        frame.setLayout(null);
		        frame.setTitle("A++8.0财务解密");
		        frame.setSize(400, 170);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		        // 添加按钮
		        final JButton btn1 = new JButton("选择解密文件");
		        final JButton btn2 = new JButton("解密");
		        btn1.setBounds(80, 70, 100, 25);
		        btn2.setBounds(240, 70, 60, 25);
		        btn1.setVisible(true);
		        btn2.setVisible(true);
		        btn1.setUI(new BEButtonUI(). setNormalColor(BEButtonUI.NormalColor.blue));
		        btn2.setUI(new BEButtonUI(). setNormalColor(BEButtonUI.NormalColor.red));
		        frame.add(btn1);
		        frame.add(btn2);

		        // 设置字体
		        final Font font = new Font("宋体", Font.BOLD, 11);
		        btn1.setFont(font);
		        btn2.setFont(font);

		        // 添加显示框
		        final JLabel label = new JLabel("加密文件路径:");
		        label.setBounds(40, 20, 80, 25);
		        label.setVisible(true);
		        label.setFont(font);
		        frame.add(label);

		        // 添加文本框
		        final JTextField textField = new JTextField();
		        textField.setBounds(120, 20, 190, 22);
		        textField.setVisible(true);
		        frame.add(textField);
		        frame.setVisible(true);

		        // 为按钮添加事件
		        btn1.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(final ActionEvent e) {
		                final JFileChooser chooser = new JFileChooser();
		                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		                final int returnVal = chooser.showOpenDialog(btn1);
		                if (returnVal == JFileChooser.APPROVE_OPTION) {
		                    final File file = chooser.getSelectedFile();
		                    path = file.getAbsolutePath();
		                    textField.setText(path);
		                }
		            }
		        });

		        btn2.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(final ActionEvent e) {
		                final DecryptFrameClient myFrame = new DecryptFrameClient();
		                myFrame.addInfo(path);
		            }
		        });

		        // 为文本框添加事件
		        textField.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(final ActionEvent e) {
		                if (new File(textField.getText()).isDirectory()) {
		                    path = textField.getText();
		                } else {
		                    final DecryptFrameClient myFrame = new DecryptFrameClient();
		                    myFrame.addInfo("路径名错误");
		                }

		            }
		        });

	}
	public void addInfo(final String string) {
		final JFrame f = new JFrame("提示");
		f.setLayout(null);
		f.setBounds(40, 40, 300, 100);
		f.setVisible(true);
		final JLabel label = new JLabel(string);
		label.setBounds(30, 20, 250, 20);
		final Font f1 = new Font("宋体", Font.BOLD, 12);
		label.setFont(f1);
		f.add(label);
		
	}
 
	@Override
   public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
  }
}
