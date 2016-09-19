package info.dgsoft.restful.impl;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import info.dgsoft.restful.api.service.DGTrack;

public interface KMLServiceInterface
{

	StringBuffer getKML(Collection<DGTrack> tracks) throws FileNotFoundException, UnsupportedEncodingException;

}
