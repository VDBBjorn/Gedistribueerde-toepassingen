﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Deze code is gegenereerd met een hulpprogramma.
//     Runtime-versie:2.0.50727.4206
//
//     Als u wijzigingen aanbrengt in dit bestand, kan dit onjuist gedrag veroorzaken wanneer
//     de code wordt gegenereerd.
// </auto-generated>
//------------------------------------------------------------------------------



[System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
[System.ServiceModel.ServiceContractAttribute(ConfigurationName="ITijdService")]
public interface ITijdService
{
    
    [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ITijdService/GetServerTime", ReplyAction="http://tempuri.org/ITijdService/GetServerTimeResponse")]
    System.DateTime GetServerTime();
}

[System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
public interface ITijdServiceChannel : ITijdService, System.ServiceModel.IClientChannel
{
}

[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "3.0.0.0")]
public partial class TijdServiceClient : System.ServiceModel.ClientBase<ITijdService>, ITijdService
{
    
    public TijdServiceClient()
    {
    }
    
    public TijdServiceClient(string endpointConfigurationName) : 
            base(endpointConfigurationName)
    {
    }
    
    public TijdServiceClient(string endpointConfigurationName, string remoteAddress) : 
            base(endpointConfigurationName, remoteAddress)
    {
    }
    
    public TijdServiceClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
            base(endpointConfigurationName, remoteAddress)
    {
    }
    
    public TijdServiceClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
            base(binding, remoteAddress)
    {
    }
    
    public System.DateTime GetServerTime()
    {
        return base.Channel.GetServerTime();
    }
}