package com.ef.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ef.model.AccessDTO;

public interface AccessService {
	public enum TypeDuration {
		HOURLY(1), DAILY(24);

		private Integer duration;

		TypeDuration(Integer duration) {
			this.duration = duration;
		}

		public Integer getDuration() {
			return this.duration;
		}
	}

	public void loadData(String file);

	public List<AccessDTO> find(LocalDateTime startDate, TypeDuration duration, Integer threshold);

	public void blockIP(List<AccessDTO> accesses, TypeDuration duration);
}
