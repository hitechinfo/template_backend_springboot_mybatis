package com.skcc.backend.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommonCodesDto {
	private String groupId;
	private String codeName;
	private String codeValue;
	private Integer codeOrder;
	private String createUserId;
	private String updateUserId;
}
