package edu.sjsu.cmpe275.lab1.aspect;

	import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import edu.sjsu.cmpe275.lab1.exception.UnAuthorisedException;
import edu.sjsu.cmpe275.lab1.service.FileService;

	@Aspect
	public class FileShareAccessControl {

		/**
		 * @param jp
		 * @throws Throwable : create own, custom, throwable.
		 */
		@Around("execution(* edu.sjsu.cmpe275.lab1.service.FileService.shareFile(..))")
		public void validateShare(ProceedingJoinPoint jp) throws Throwable {

			Object[] var = jp.getArgs();

			if(var.length > 0) {
				String userId = (String)var[0];
				String targetUserId = (String)var[1];
				String filePath = (String)var[2];

				if(userId.equals(targetUserId)) {
					return;
				}

				if(FileService.userData.containsKey(userId)) {
					if(filePath.contains(userId)) {
						System.out.println(userId+" shares the file "+filePath+" with "+targetUserId);
						jp.proceed();
					} else {
						if(FileService.userData.get(userId).contains(filePath)) {
							System.out.println(userId+" shares the file "+filePath+" with "+targetUserId);
							jp.proceed();
						} else {
							throw new UnAuthorisedException(userId+" cannot share the file "+filePath+" with "+targetUserId);
						}
					}
				} else {
					throw new UnAuthorisedException("User: "+userId+" does not exist");
				}

			} else {
				throw new Exception("Invalid number of arguments");
			}

		}

		/**
		 * @param jp
		 * @throws Throwable
		 */
		@Around("execution(* edu.sjsu.cmpe275.lab1.service.FileService.unshareFile(..))")
		public void validateUnShare(ProceedingJoinPoint jp) throws Throwable {
			Object[] var = jp.getArgs();
			if(var.length > 0) {
				String userId = (String)var[0];
				String targetUserId = (String)var[1];
				String filePath = (String)var[2];

				if(userId.equals(targetUserId)) {
					return;
				}

				if(FileService.userData.containsKey(userId)) {
					if(filePath.contains(userId)) {
						System.out.println(userId+" unshares the file "+filePath+" with "+targetUserId);
						jp.proceed();
					}
				} else {
					throw new UnAuthorisedException("User: "+userId+" does not exist");
				}

			} else {
				throw new Exception("Invalid number of arguments");
			}
		}
		
		
		/**
		 * @param jp
		 * @return It returns the content of the file
		 * @throws Throwable
		 */
		@Around("execution(* edu.sjsu.cmpe275.lab1.service.FileService.readFile(..))")
		public byte[] validateReadFile(ProceedingJoinPoint jp) throws Throwable {
			Object[] var = jp.getArgs();
			if(var.length > 0) {
				String userId = (String)var[0];
				String filePath = (String)var[1];
				
				if(FileService.userData.containsKey(userId)) {
					if(filePath.contains(userId)) {
						System.out.println(userId+" reads the file "+filePath);
						byte[] b = (byte[]) jp.proceed();
						return b;
					} else {
						if(FileService.userData.get(userId).contains(filePath)) {
							System.out.println(userId+" reads the file "+filePath);
							byte[] b = (byte[]) jp.proceed();
							return b;
						} else {
							throw new UnAuthorisedException(userId+" cannot read the file "+filePath);
						}
					}
				} else {
					throw new UnAuthorisedException("User: "+userId+" does not exist");
				}
				
			} else {
				throw new Exception("Invalid number of arguments");
			}
			
		}

	
}
