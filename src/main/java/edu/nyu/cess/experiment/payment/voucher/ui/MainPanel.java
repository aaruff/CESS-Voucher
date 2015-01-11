package edu.nyu.cess.experiment.payment.voucher.ui;

import edu.nyu.cess.experiment.payment.voucher.ui.buttons.PayFileToPdfButton;
import edu.nyu.cess.experiment.payment.voucher.ui.labels.*;
import edu.nyu.cess.experiment.payment.voucher.ui.listeners.ConvertPaymentFileListener;
import edu.nyu.cess.experiment.payment.voucher.ui.listeners.SelectPaymentFileListener;
import edu.nyu.cess.experiment.payment.voucher.io.ZTreePayFileConverter;
import edu.nyu.cess.experiment.payment.voucher.ui.buttons.PayFileSelectButton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * The type Payoff converter panel.
 */
public class MainPanel extends JPanel implements FileSelectionObserver, FileConversionObserver
{
	private static final long serialVersionUID = 2853708307420292816L;

	private ZTreePayFileConverter payFileConverter;

    private StatusLabel statusLabel;

	/**
	 * Instantiates a new Payoff converter panel.
     */
	public MainPanel(ZTreePayFileConverter payFileConverter)
	{
		this.payFileConverter = payFileConverter;
		statusLabel = new StatusLabel(new InfoLabelProperty());

    	layoutComponents();
    }

	/**
	 * Gets status label.
	 *
	 * @return the status label
     */
	@Override
	public void updateStatus(StatusType statusType, String message)
	{
		statusLabel.updateLabel(LabelPropertyFactory.buildLabelProperty(statusType, message));
	}

	@Override
	public JPanel getJPanel()
	{
		return this;
	}

	@Override
	public void updateFileSelection(File payoffFile)
	{
		payFileConverter.setFileInfo(payoffFile.getPath());
		updateStatus(StatusType.INFO, "Opened: " + payoffFile.getName());
	}

	/**
	 * Notifies the panel that a conversion request has been made.
	 */
	public void updateConversionRequest()
	{
		try {
			payFileConverter.convertPaymentToVoucherPDF();
		} catch (Exception e) {
			updateStatus(StatusType.ERROR, e.getMessage());
		}
	}

	/**
	 * Init void.
	 */
	public void layoutComponents()
	{
        JPanel mainLayoutPanel = new JPanel(new MigLayout());
        
        mainLayoutPanel.add(new CESSLogoLabel(), "align right");
		mainLayoutPanel.add(new HeaderLabel(), "wrap");

        mainLayoutPanel.add(new PayFileSelectButton(new SelectPaymentFileListener(this)));
        mainLayoutPanel.add(new JLabel(IconFactory.produceNextIcon()), "align center");
        mainLayoutPanel.add(new PayFileToPdfButton(new ConvertPaymentFileListener(this)), "wrap");
        
        mainLayoutPanel.add(statusLabel, "span x, align center");
        
        add(mainLayoutPanel, BorderLayout.PAGE_START);
    }
}
