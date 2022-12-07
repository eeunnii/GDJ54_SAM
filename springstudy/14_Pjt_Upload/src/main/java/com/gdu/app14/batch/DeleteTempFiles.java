package com.gdu.app14.batch;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.app14.util.MyFileUtil;

@EnableScheduling
@Component
public class DeleteTempFiles {

	// 삭제되는지 테스트는 아래 크론식으로 확인
	// cron="0 0/1 * * * *"(1분마다 storage/temp 디렉터리의 파일을 지움)
	@Autowired
	private MyFileUtil myFileUtil;
	
	@Scheduled(cron="0 0 3 * * *")  // 새벽 3시마다 동작
	public void execute() {
		
		String tempPath = myFileUtil.getTempPath();  // 루트/storage
		File tempDir = new File(tempPath);
		
		if(tempDir.exists()) {
			File[] tempFiles = tempDir.listFiles();
			for(File temp : tempFiles) {
				temp.delete();
			}
		}
		
	}
	
}
