package sif3.au.naplan.provider.service.impl;

import org.springframework.stereotype.Service;

import sif3.au.naplan.credentials.NaplanCredentials;
import sif3.au.naplan.provider.service.NaplanCredentialsService;
import sif3.common.CommonConstants.AdapterType;
import sif3.common.model.AuthenticationInfo;
import sif3.common.model.RequestMetadata;
import sif3.common.persist.model.SIF3Session;
import sif3.common.utils.AuthenticationUtils;
import sif3.infra.common.env.mgr.ProviderManagerFactory;

@Service
public class NaplanCredentialsServiceImpl implements NaplanCredentialsService {

    @Override
    public NaplanCredentials getCredentialsForRequest(RequestMetadata metadata) {
        // Perhaps we do something different in the future like :
        // - a mapping between our logged in user and naplan user
        // - the consumer could pass through custom http headers
        // - a configuration option
        // - all of the above?
        // For now take the current application key and password and pass that back.
        // Will need to implement something different here in a brokered environment.
        String applicationKey = metadata.getApplicationKey();
        // Retrieve the AuthenticationInfo from the Authorization Header
        AuthenticationInfo authenticationInfo = AuthenticationUtils.getPartsFromAuthToken(metadata.getRequestParameters().getHttpHeaderParams().getHeaderProperty("Authorization"),
                AdapterType.PROVIDER);
        // Retrieve the SIF3Session from the Session store.
        SIF3Session session = ProviderManagerFactory.getEnvironmentManager().getSessionBySessionToken(authenticationInfo.getUserToken());
        String password = session.getPassword();
        return new NaplanCredentials(applicationKey, password);
    }

}
