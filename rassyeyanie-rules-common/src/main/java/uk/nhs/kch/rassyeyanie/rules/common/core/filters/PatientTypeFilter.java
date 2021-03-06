package uk.nhs.kch.rassyeyanie.rules.common.core.filters;

import uk.nhs.kch.rassyeyanie.framework.HapiUtil;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.v24.segment.PV1;

// Patient Type - PV1-18:  PIMS sends out 01: Private Patient, NHS: NSH patient
public class PatientTypeFilter extends GenericFilter
{
    @Override
    protected String getValueFromMessage(AbstractMessage message)
        throws HL7Exception
    {
        PV1 pv1 = HapiUtil.getWithTerser(message, PV1.class);
        return pv1.getPatientType().getValue();
    }
}
