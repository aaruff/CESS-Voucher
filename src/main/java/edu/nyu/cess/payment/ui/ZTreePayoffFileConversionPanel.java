package edu.nyu.cess.payment.ui;

import edu.nyu.cess.payment.io.ZTreePayFileConverter;
import edu.nyu.cess.payment.ui.buttons.CreatePDFButton;
import edu.nyu.cess.payment.ui.buttons.OpenFileButton;
import edu.nyu.cess.payment.ui.labels.*;
import edu.nyu.cess.payment.ui.listeners.ConvertPaymentFileListener;
import edu.nyu.cess.payment.ui.listeners.OpenPaymentFileListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * The type Payoff converter panel.
 */
public class ZTreePayoffFileConversionPanel extends JPanel
{
	private static final long serialVersionUID = 2853708307420292816L;

	private ZTreePayFileConverter payFileConverter;

	private GridBagConstraints constraint;

    private JButton openPaymentFileButton, paymentFileToVoucherButton;
    private StatusLabel statusLabel;

	/**
	 * Instantiates a new Payoff converter panel.
     */
	public ZTreePayoffFileConversionPanel(ZTreePayFileConverter payFileConverter)
	{
		this.payFileConverter = payFileConverter;

		statusLabel = new StatusLabel(new InfoLabelProperty());

		openPaymentFileButton = new OpenFileButton(new OpenPaymentFileListener(this));
		paymentFileToVoucherButton = new CreatePDFButton(new ConvertPaymentFileListener(this));

    	init();
    }

	/**
	 * Gets status label.
	 *
	 * @return the status label
     */
	public void updateStatus(StatusType statusType, String message)
	{
		statusLabel.updateLabel(LabelPropertyFactory.buildLabelProperty(statusType, message));
	}

	public void updatePayFileConverter(File payoffFile)
	{
		payFileConverter.setFileInfo(payoffFile.getPath());
		updateStatus(StatusType.INFO, "Opened: " + payoffFile.getName());
	}

	/**
	 * Init void.
	 */
	public void init()
	{
        JPanel fileSelectionPanel = new JPanel(new GridBagLayout());
        
        JPanel cessLogoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        cessLogoPanel.add(new CESSLogoLabel());
		cessLogoPanel.add(new HeaderLabel());

		constraint = new GridBagConstraints();
		constraint.gridwidth = GridBagConstraints.REMAINDER;
		constraint.insets = new Insets(20, 20, 20, 20);
        fileSelectionPanel.add(cessLogoPanel, constraint);

		constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 2;
		constraint.insets = new Insets(0, 0, 10, 0);
        fileSelectionPanel.add(openPaymentFileButton, constraint);
        
        JLabel nextIconLabel = new JLabel(IconFactory.createImageIcon("/resources/images/next.png", "Next"));
		constraint = new GridBagConstraints();
		constraint.gridx = 1;
		constraint.gridy = 2;
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.insets = new Insets(0, 30, 10, 30);
        fileSelectionPanel.add(nextIconLabel, constraint);
        
		constraint = new GridBagConstraints();
		constraint.gridx = 2;
		constraint.gridy = 2;
		constraint.insets = new Insets(0, 0, 10, 0);
        fileSelectionPanel.add(paymentFileToVoucherButton, constraint);
        
		constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 3;
		constraint.gridwidth = GridBagConstraints.REMAINDER;
		constraint.insets = new Insets(0, 10, 0, 0);
        fileSelectionPanel.add(statusLabel, constraint);
        
        //Add the buttons and the log to this panel.
        add(fileSelectionPanel, BorderLayout.PAGE_START);
    }
}
