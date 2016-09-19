package info.dgsoft.restful.impl;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.ContentHandler;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import org.springframework.stereotype.Service;

import de.micromata.opengis.kml.v_2_2_0.AltitudeMode;
import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.KmlFactory;
import de.micromata.opengis.kml.v_2_2_0.LineString;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Point;
import info.dgsoft.restful.api.service.DGTrack;

@Service
public class KMLService implements KMLServiceInterface
{

	@Override
	public StringBuffer getKML(Collection<DGTrack> tracks)
			throws FileNotFoundException, UnsupportedEncodingException
	{
		// The all encapsulating kml element.
		Kml kml = KmlFactory.createKml();
		LineString path = KmlFactory.createLineString();
		Placemark placemarkForPath = KmlFactory.createPlacemark();
		placemarkForPath.setName("Path for " );
		placemarkForPath.setVisibility(true);
		placemarkForPath.setOpen(false);
		placemarkForPath.setDescription("");
		for (DGTrack track : tracks)
		{
			path.addToCoordinates(track.getLongitude(), track.getLatitude());
			// Create <Placemark> and set values.
			Placemark placemark = KmlFactory.createPlacemark();
			placemark.setName(track.getOrigin());
			placemark.setVisibility(true);
			placemark.setOpen(false);
			placemark.setDescription(track.getLocalTime().toLocalDateTime().toString());

			// Create <Point> and set values.
			Point point = KmlFactory.createPoint();
			point.setExtrude(false);
			point.setAltitudeMode(AltitudeMode.CLAMP_TO_GROUND);
			// Add coordinates
			point.addToCoordinates(track.getLongitude(), track.getLatitude());

			placemark.setGeometry(point); // <-- point is registered at
											// placemark ownership.
			kml.setFeature(placemark); // <-- placemark is registered at kml
										// ownership.

		}
		placemarkForPath.setGeometry(path);
		kml.setFeature(placemarkForPath);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		kml.marshal(out); // <-- Print the KML structure to the console.
		String kmlString = new String(out.toByteArray(), "UTF-8");
		return new StringBuffer(kmlString);
	}

}