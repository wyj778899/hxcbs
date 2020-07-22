package chinaPress.common.util;

import java.text.NumberFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.SftpProgressMonitor;

import chinaPress.common.wxpay.WXPayUtil;

public class MyProgressMonitor implements SftpProgressMonitor, Runnable {
	private long maxCount = 0;// 文件的总大小
	public long startTime = 0L;
	private long uploaded = 0;
	private boolean isScheduled = false;
	private Logger logger = WXPayUtil.getLogger();
	ScheduledExecutorService executorService;

	public MyProgressMonitor(long maxCount) {
		this.maxCount = maxCount;
	}

	@Override
	public void run() {
		NumberFormat format = NumberFormat.getPercentInstance();
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(2);
		String value = format.format((uploaded / (double) maxCount));
		System.out.println("已传输：" + uploaded / 1024 + "KB,传输进度：" + value);
		if (uploaded == maxCount) {
			stop();
			long endTime = System.currentTimeMillis();
			System.out.println("传输完成！用时：" + (endTime - startTime) / 1000 + "s");
		}

	}

	/**
	 * 输出每个时间段的上传大小
	 */
	@Override
	public boolean count(long count) {
		if (!isScheduled) {
			createTread();
		}
		uploaded += count;
		// System.out.println("本次上传大小：" + count / 1024 + "KB,");
		if (count > 0) {
			return true;
		}
		return false;

	}

	/**
	 * 文件上传结束时调用
	 */
	@Override
	public void end() {
		// System.out.println("文件传输结束");
	}

	/**
	 * 文件上传时开始调用
	 */
	@Override
	public void init(int op, String src, String dest, long max) {
		System.out.println("开始上传文件：" + src + "至远程：" + dest + "文件总大小:" + maxCount / 1024 + "KB");
		startTime = System.currentTimeMillis();
	}

	/**
	 * 创建一个线程每隔一定时间，输出一下上传进度
	 */
	public void createTread() {
		executorService = Executors.newSingleThreadScheduledExecutor();
		// 1秒钟后开始执行，每2杪钟执行一次
		executorService.scheduleWithFixedDelay(this, 1, 2, TimeUnit.SECONDS);
		isScheduled = true;
	}

	/**
	 * 停止方法
	 */
	public void stop() {
		boolean isShutdown = executorService.isShutdown();
		if (!isShutdown) {
			executorService.shutdown();
		}

	}
}