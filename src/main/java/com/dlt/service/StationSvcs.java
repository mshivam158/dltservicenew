package com.dlt.service;

import org.springframework.stereotype.Service;

import com.dlt.repos.IStationRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StationSvcs {
	//@Autowired
	private IStationRepo stationRepos;
}
