package info.dgsoft.restful.controller;

import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import info.dgsoft.restful.api.service.DGTrack;
import info.dgsoft.restful.domain.entity.DGTrackEntity;
import info.dgsoft.restful.impl.KMLServiceInterface;
import info.dgsoft.restful.impl.TracksInterface;
import info.dgsoft.restful.model.factory.DGTrackFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class TrackController
{
	private final Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private TracksInterface trackImpl;
	@Autowired
	private KMLServiceInterface kmlImpl;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(method = RequestMethod.POST, value = "/public/track",
			params = { "phone", "time", "longitude", "latitude", "speed" },
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> setTrack(@RequestParam("phone") String phone,
			@RequestParam("time") String time, @RequestParam("longitude") Double longitude,
			@RequestParam("latitude") Double latitude, @RequestParam("speed") Double speed)
	{
		trackImpl.saveTrack(new DGTrackEntity(0, phone, longitude, latitude,
				new Timestamp(Long.parseLong(time)), speed));
		return ResponseEntity.ok(new String(""));
	}

	@ApiOperation(value = "GetTracks", nickname = "nick GetTracks", notes = "gets the tracks")
	@ApiResponses(
			value = { @ApiResponse(code = 200, message = "Success", response = DGTrackEntity.class),
					@ApiResponse(code = 401, message = "Unauthorized"),
					@ApiResponse(code = 403, message = "Forbidden"),
					@ApiResponse(code = 404, message = "Not Found"),
					@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/public/track/{origin}", method = RequestMethod.GET,
			produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> getTracks(@PathVariable String origin)
	{
		Collection<DGTrackEntity> entities = trackImpl.getTracks(origin);
		Collection<DGTrack> tracks = new ArrayList<>();
		for (DGTrackEntity entity : entities)
		{
			tracks.add(DGTrackFactory.create(entity));
		}
		return ResponseEntity.ok(tracks);
	}

	@ApiOperation(value = "GetKMLTracks", nickname = "nick GetKMLTracks",
			notes = "gets the KMLtracks")
	@ApiResponses(
			value = { @ApiResponse(code = 200, message = "Success", response = DGTrackEntity.class),
					@ApiResponse(code = 401, message = "Unauthorized"),
					@ApiResponse(code = 403, message = "Forbidden"),
					@ApiResponse(code = 404, message = "Not Found"),
					@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/public/track/{origin}/*kml", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getKMLTracks(@PathVariable String origin) throws Throwable
	{
		Collection<DGTrackEntity> entities = trackImpl.getTracks(origin);
		Collection<DGTrack> tracks = new ArrayList<>();
		for (DGTrackEntity entity : entities)
		{
			tracks.add(DGTrackFactory.create(entity));
		}
		StringBuffer buff;
		buff = kmlImpl.getKML(tracks);
		return ResponseEntity.ok().contentType(MediaType.TEXT_XML).body(buff.toString());
	}

	@ApiOperation(value = "GetTracked", nickname = "nick GetTracked", notes = "gets the tracked")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/public/track", method = RequestMethod.GET,
			produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> getTracked()
	{
		Collection<String> tracked = trackImpl.getTracked();
		return ResponseEntity.ok(tracked);
	}

}
