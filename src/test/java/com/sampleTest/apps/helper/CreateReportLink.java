package com.sampleTest.apps.helper;

import java.net.URL;
import org.apache.log4j.Logger;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

	public class CreateReportLink {
		
		private static Logger log = Logger.getLogger(Logger.class.getName());
		private String bucketName = "adfautomationreports";
		private String accessKey = "AKIAJNUVWLQO7YVDOZPA";
		private String secretKey = "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";
		
		
		public URL generatePresignedURL(String objectKey){
			
			
			BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);

			AmazonS3 s3client = new AmazonS3Client(awsCreds);

			log.info("Generating pre-signed URL.");
			java.util.Date expiration = new java.util.Date();
			long milliSeconds = expiration.getTime();
			milliSeconds += 1000 * 60 * 10080; // Add 7 days.
			expiration.setTime(milliSeconds);
			GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey);
			generatePresignedUrlRequest.setMethod(HttpMethod.PUT); 
			generatePresignedUrlRequest.setExpiration(expiration);

			URL url = s3client.generatePresignedUrl(generatePresignedUrlRequest); 
			
			return url;
		}
}
