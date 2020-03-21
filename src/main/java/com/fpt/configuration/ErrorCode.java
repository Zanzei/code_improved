package com.fpt.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {

	SUCCESS("00", "Success."),
	GENERAL_EXCEPTION("01", "Sorry, there's been an error."),
	FAILED_OPERATION("02", "Operation failed."),
	NOT_FOUND("03", "Data not found.");
	
	private String code;
	private String message;
	
}
